package tomaszkopacz.meetbam.presenter

import android.os.Environment
import android.widget.Toast
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.dialogs.ProgressDialog
import tomaszkopacz.meetbam.entity.Post
import tomaszkopacz.meetbam.interactor.AuthService
import tomaszkopacz.meetbam.interactor.DatabaseService
import tomaszkopacz.meetbam.interactor.StorageService
import tomaszkopacz.meetbam.interactor.TaskListener
import tomaszkopacz.meetbam.router.CameraRouter
import tomaszkopacz.meetbam.view.MainActivity
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.MainPhotoFragment
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MainPhotoFragmentPresenter(private val fragment: MainPhotoFragment) {

    @Inject
    lateinit var authService: AuthService

    @Inject
    lateinit var databaseService: DatabaseService

    @Inject
    lateinit var storageService: StorageService

    private var currentImageFile: File? = null

    private var loggedUser: String? = null
    private var pairedUser: String? = null

    private val progressDialog: ProgressDialog = ProgressDialog(fragment.activity)

    init {
        (fragment.activity!!.application as MainApp).component!!.inject(this)
        loggedUser = authService.getCurrentUser()!!.displayName
    }

    fun takePhoto(camera: CameraRouter) {
        progressDialog.show()
        currentImageFile = createImageFile(getImageGallery())
        camera.takePicture(currentImageFile!!, fragment.context!!, photoListener)
    }

    fun dismissPhoto() {
        /*
             REMOVE IMAGE FROM DIRECTORY
         */
        clearMemory()
        fragment.clearLayout()
    }

    fun pair() {
        progressDialog.show()
        loggedUser = authService.getCurrentUser()!!.displayName
        pairedUser = "Zbyszek Wodecki"
        progressDialog.dismiss()
        fragment.notifyUsersPaired(loggedUser!!, pairedUser!!)
    }

    fun acceptPhoto() {
        progressDialog.show()

        val post: Post?

        if (areUsersAvailable() && isImageAvailable()){
            post = createPost()
            post.photo_dir = storageService.uploadFile(currentImageFile!!, uploadPhotoListener)
            databaseService.putPost(post, uploadPostListener)

        } else {
            progressDialog.dismiss()
            Toast.makeText(fragment.context, "ERROR", Toast.LENGTH_LONG).show()
        }

        clearMemory()
        progressDialog.dismiss()
        fragment.clearLayout()
        (fragment.activity as MainActivity).changePage(MainActivity.POSTS)
    }

    private val uploadPhotoListener = object : TaskListener {
        override fun onSucceed() {
        }

        override fun onFailed() {
        }
    }

    private val uploadPostListener = object : TaskListener {
        override fun onSucceed() {
        }

        override fun onFailed() {
        }

    }

    private fun areUsersAvailable(): Boolean {
        return (loggedUser != null && pairedUser != null)
    }

    private fun isImageAvailable(): Boolean {
        return currentImageFile != null
    }

    private fun createPost(): Post {
        val post = Post()
        post.name1 = loggedUser
        post.name2 = pairedUser
        post.time = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
                .format(Date())

        return post
    }

    private fun createImageFile(galleryFolder: File): File {
        val prefix = fragment.context!!.getString(R.string.app_name)
        val suffix = ".png"
        return File.createTempFile(prefix, suffix, galleryFolder)
    }

    private fun getImageGallery(): File {
        val storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val galleryFolder = File(storageDir, fragment.resources.getString(R.string.app_name))

        if (!galleryFolder.exists()) {
            galleryFolder.mkdirs()
        }

        return galleryFolder
    }

    private val photoListener = object : CameraRouter.PhotoStateListener {
        override fun onPhotoInProgress() {
        }

        override fun onPhotoTaken() {
            fragment.showPhoto(currentImageFile!!)
            progressDialog.dismiss()
        }

        override fun onError() {
            progressDialog.dismiss()
        }
    }

    private fun clearMemory() {
        currentImageFile = null
        loggedUser = null
        pairedUser = null
    }
}