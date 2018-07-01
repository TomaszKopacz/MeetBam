package tomaszkopacz.meetbam.presenter

import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Environment
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.dialogs.ChooseDeviceDialog
import tomaszkopacz.meetbam.dialogs.ChooseDeviceDialogPresenter
import tomaszkopacz.meetbam.dialogs.CommitPhotoDialog
import tomaszkopacz.meetbam.dialogs.CommitPhotoDialogPresenter
import tomaszkopacz.meetbam.entity.Post
import tomaszkopacz.meetbam.entity.User
import tomaszkopacz.meetbam.interactor.WebService
import tomaszkopacz.meetbam.router.BluetoothRouter
import tomaszkopacz.meetbam.service.CameraService
import tomaszkopacz.meetbam.service.LoginService
import tomaszkopacz.meetbam.service.PostAdapter
import tomaszkopacz.meetbam.service.PostViewHolder
import tomaszkopacz.meetbam.view.LoginActivity
import tomaszkopacz.meetbam.view.MainActivity
import tomaszkopacz.meetbam.view.MainApp
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MainActivityPresenter(private val activity: MainActivity)
    : RecyclerViewPresenter, CommitPhotoDialogPresenter,
        ChooseDeviceDialogPresenter, BluetoothPresenter {

    //service
    @Inject lateinit var webService: WebService
    private var mLoginService = LoginService(activity.applicationContext)
    private var bluetoothRouter = BluetoothRouter(this)

    //posts
    private var adapter: PostAdapter = PostAdapter(this)
    private var posts: MutableList<Post> = ArrayList()

    //making a photo | choosing device | pairing
    private var commitPhotoDialog: CommitPhotoDialog? = null
    private var chooseDeviceDialog: ChooseDeviceDialog? = null
    private var discoveredDevices = ArrayList<BluetoothDevice>()
    private var photoUri: Uri? = null
    private var pairedUser: User? = null

    companion object {
        private val BASE_URL = "http://meetbam.cba.pl/"
        private val PHOTO_DIRECTORY = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES).toString() + "/Meetbam/"
    }

    init {
        (activity.application as MainApp).webServiceComponent!!.inject(this)
    }

    fun downloadPosts() {
        posts.clear()

        val call = webService.getFriendsPosts(mLoginService.getLoggedUser().mail!!)
        call.enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                posts = response.body() as MutableList<Post>
                activity.putPosts(adapter)
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }
        })
    }

    fun takePhoto() {
        photoUri = getCustomPhotoUri()
        val img = File(photoUri!!.path)
        val cameraIntent = CameraService.getCameraIntent(img)
        activity.startActivityForResult(cameraIntent, MainActivity.CAMERA_CODE)
    }

    fun photoTaken() {
        commitPhotoDialog = CommitPhotoDialog(activity, this)
        commitPhotoDialog!!.loadPhoto(photoUri!!)
        commitPhotoDialog!!.show()
    }

    override fun pair() {
        pairedUser = null

        if (!BluetoothRouter.isBluetoothOn())
            requestBT()

        else {
            chooseDeviceDialog = ChooseDeviceDialog(activity, this)
            bluetoothRouter.startReceiving(activity)
            scanDevices()
        }
    }

    fun paired(user: User){
        commitPhotoDialog!!.progressBar.visibility = View.GONE

        pairedUser = user
        val name = pairedUser!!.name
        val surname = pairedUser!!.surname
        commitPhotoDialog!!.personTextView.text = activity.getString(R.string.paired_user, name, surname)

        commitPhotoDialog!!.acceptBtn.isClickable = true
        commitPhotoDialog!!.acceptBtn.setTextColor(Color.BLACK)
    }

    override fun commitPost(photoUri: Uri) {
        commitPhotoDialog!!.dismiss()
        val service = LoginService(activity)

        val photo = File(photoUri.path)
        val requestBody = RequestBody.create(MediaType.parse("*/*"), photo)
        val file = MultipartBody.Part.createFormData("file", photo.name, requestBody)
        val user1 = RequestBody.create(MediaType.parse("text/plain"), service.getLoggedUser().mail!!)
        val user2 = RequestBody.create(MediaType.parse("text/plain"), pairedUser!!.mail!!)

        val call = webService.uploadPost(file, user1, user2)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Snackbar.make(activity.findViewById(R.id.coordinator),
                        "Photo uploaded successfully!", Snackbar.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Snackbar.make(activity.findViewById(R.id.coordinator),
                        "Ups! Error while uploading photo!", Snackbar.LENGTH_LONG).show()
            }
        })

        pairedUser = null
    }

    fun logout() {
        mLoginService.logout()

        val intent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    /*==============================================================================================
                                    POSTS ITEMS
     =============================================================================================*/

    override fun onItemBoundAtPosition(holder: RecyclerView.ViewHolder, position: Int) {
        val post = posts[position]
        (holder as PostViewHolder).setContent(activity, post, BASE_URL)
    }

    override fun onItemClick(view: View) {
        //int position = activity.getPostsRecView().getChildAdapterPosition(view);
        //posts.remove(position);
        //adapter.notifyItemRemoved(position);
    }

    override fun itemCount(): Int {
        return posts.size
    }

    /*==============================================================================================
                                    SAVING IMAGE
     =============================================================================================*/
    private fun getCustomPhotoUri() : Uri {
        val dateFormat = SimpleDateFormat("yyyyMMddhhmmssSSSS", Locale.US)
        val photoFileName = dateFormat.format(Date()) + ".jpg"
        val photoFile = getPhotoDirectory(PHOTO_DIRECTORY, photoFileName)

        return Uri.fromFile(photoFile)
    }

    private fun getPhotoDirectory(directory: String, fileName: String): File {

        val pathFile = File(directory)
        val file: File
        val dir = directory + fileName

        pathFile.mkdirs()
        file = File(dir)
        file.createNewFile()

        return file
    }

    /*==============================================================================================
                                PAIRING DEVICES VIA BLUETOOTH
    ==============================================================================================*/
    private fun requestBT() {
        val btRequestSnackBar = Snackbar
                .make(activity.findViewById(R.id.coordinator),
                        "Bluetooth turned off",
                        Snackbar.LENGTH_LONG)
                .setAction("OPEN") {
                    BluetoothRouter.openBluetooth()
                }
        btRequestSnackBar.show()
    }

    private fun scanDevices() {
        discoveredDevices.clear()
        commitPhotoDialog!!.progressBar.visibility = View.VISIBLE
        afterDiscoveryHandler.postDelayed(afterDiscoveryRunnable, 5000)
        BluetoothRouter.startDiscovery()
    }

    override fun deviceDiscovered(device: BluetoothDevice) {
        discoveredDevices.add(device)
    }

    private var afterDiscoveryHandler = Handler()
    private var afterDiscoveryRunnable = Runnable {
        BluetoothRouter.stopDiscovery()
        bluetoothRouter.stopReceiving(activity)

        chooseDeviceDialog!!.setDevices(discoveredDevices)
        chooseDeviceDialog!!.show()
    }

    override fun deviceSelected(device: BluetoothDevice) {
        val call = webService.getUserLoggedOnDevice(device.address)
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                if (response.body()!!.isNotEmpty()) {
                    paired(response.body()!![0])
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {}
        })

        chooseDeviceDialog!!.dismiss()
    }
}
