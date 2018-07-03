package tomaszkopacz.meetbam.presenter

import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.os.Handler
import tomaszkopacz.meetbam.dialogs.ChooseDeviceDialog
import tomaszkopacz.meetbam.dialogs.ChooseDeviceDialogPresenter
import tomaszkopacz.meetbam.dialogs.CommitPhotoDialog
import tomaszkopacz.meetbam.dialogs.CommitPhotoDialogPresenter
import tomaszkopacz.meetbam.entity.User
import tomaszkopacz.meetbam.router.BluetoothRouter
import tomaszkopacz.meetbam.service.LoginService
import tomaszkopacz.meetbam.view.LoginActivity
import tomaszkopacz.meetbam.view.MainActivity
import java.util.*


class MainActivityPresenter(private val activity: MainActivity)
    : CommitPhotoDialogPresenter, ChooseDeviceDialogPresenter, BluetoothPresenter {

    private var mLoginService = LoginService(activity.applicationContext)
    private var bluetoothRouter = BluetoothRouter(this)

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

    override fun pair() {
//        pairedUser = null
//
//        if (!BluetoothRouter.isBluetoothOn())
//            requestBT()
//
//        else {
//            chooseDeviceDialog = ChooseDeviceDialog(fragment.activity!!, this)
//            bluetoothRouter.startReceiving(fragment.activity!!)
//            scanDevices()
//        }
    }

    fun paired(user: User){
//        pairedUser = user
//        commitPhotoDialog!!.notifyUserPaired(user)
    }

    override fun commitPost(photoUri: Uri) {
//        commitPhotoDialog!!.dismiss()
//
//        val photo = File(photoUri.path)
//        val requestBody = RequestBody.create(MediaType.parse("*/*"), photo)
//        val file = MultipartBody.Part.createFormData("file", photo.name, requestBody)
//        val user1 = RequestBody.create(MediaType.parse("text/plain"), mLoginService.getLoggedUser().mail!!)
//        val user2 = RequestBody.create(MediaType.parse("text/plain"), pairedUser!!.mail!!)
//
//        val call = webService.uploadPost(file, user1, user2)
//        call.enqueue(object : Callback<ResponseBody> {
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                Snackbar.make(fragment.activity!!.findViewById(R.id.coordinator),
//                        "Photo uploaded successfully!", Snackbar.LENGTH_LONG).show()
//            }
//
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                Snackbar.make(fragment.activity!!.findViewById(R.id.coordinator),
//                        "Ups! Error while uploading photo!", Snackbar.LENGTH_LONG).show()
//            }
//        })
//
//        pairedUser = null
    }

    fun photoTaken() {
        //when photo taken
    }

    fun logout() {
        mLoginService.logout()

        val intent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    private fun getCustomPhotoUri() : Uri {
//        val dateFormat = SimpleDateFormat("yyyyMMddhhmmssSSSS", Locale.US)
//        val photoFileName = dateFormat.format(Date()) + ".jpg"
//        val photoFile = getPhotoDirectory(MainPostsFragmentPresenter.PHOTO_DIRECTORY, photoFileName)
//
//        return Uri.fromFile(photoFile)
//    }
//
//    private fun getPhotoDirectory(directory: String, fileName: String): File {
//
//        val pathFile = File(directory)
//        val file: File
//        val dir = directory + fileName
//
//        pathFile.mkdirs()
//        file = File(dir)
//        file.createNewFile()
//
//        return file
        return Uri.EMPTY
    }

    private fun requestBT() {
//        val btRequestSnackBar = Snackbar
//                .make(fragment.activity!!.findViewById(R.id.coordinator),
//                        "Bluetooth turned off",
//                        Snackbar.LENGTH_LONG)
//                .setAction("OPEN") {
//                    BluetoothRouter.openBluetooth()
//                }
//        btRequestSnackBar.show()
    }

    private fun scanDevices() {
//        discoveredDevices.clear()
//        commitPhotoDialog!!.pairInProgress()
//        afterDiscoveryHandler.postDelayed(afterDiscoveryRunnable, 5000)
//        BluetoothRouter.startDiscovery()
    }

    override fun deviceDiscovered(device: BluetoothDevice) {
//        discoveredDevices.add(device)
    }

    private var afterDiscoveryHandler = Handler()
    private var afterDiscoveryRunnable = Runnable {
//        BluetoothRouter.stopDiscovery()
//        bluetoothRouter.stopReceiving(fragment.activity!!)
//
//        chooseDeviceDialog!!.setDevices(discoveredDevices)
//        chooseDeviceDialog!!.show()
    }

    override fun deviceSelected(device: BluetoothDevice) {
//        val call = webService.getUserLoggedOnDevice(device.address)
//        call.enqueue(object : Callback<List<User>> {
//            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//
//                if (response.body()!!.isNotEmpty()) {
//                    paired(response.body()!![0])
//                }
//            }
//
//            override fun onFailure(call: Call<List<User>>, t: Throwable) {}
//        })
//
//        chooseDeviceDialog!!.dismiss()
    }
}