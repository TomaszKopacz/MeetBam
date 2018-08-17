package tomaszkopacz.meetbam.presenter

import android.util.Log
import android.widget.Toast
import tomaszkopacz.meetbam.dialogs.ProgressDialog
import tomaszkopacz.meetbam.entity.Post
import tomaszkopacz.meetbam.interactor.*
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

    @Inject
    lateinit var imageFilesService: ImageFilesService

    private var currentImageFile: File? = null

    private var loggedUser: String? = null
    private var pairedUser: String? = null

    private val progressDialog: ProgressDialog = ProgressDialog(fragment.activity!!)

    init {
        (fragment.activity!!.application as MainApp).component!!.inject(this)

        val logged = authService.getCurrentUser()
        loggedUser = if (logged!!.displayName == null || logged.displayName!!.isEmpty())
            logged.email else logged.displayName
    }

    fun takePhoto(camera: CameraRouter) {
        progressDialog.show()
        currentImageFile = imageFilesService.createPostImageFile()
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
        pairedUser = "Zbyszek Wodecki"
        progressDialog.dismiss()
        fragment.notifyUsersPaired(loggedUser!!, pairedUser!!)
    }

    fun acceptPhoto() {
        progressDialog.show()

        val post: Post?

        if (areUsersAvailable() && isImageAvailable()){
            post = createPost()

            val photoUrl = storageService.uploadPostPhoto(currentImageFile!!, uploadPhotoListener)
            post.url = photoUrl
            databaseService.putPost(post, uploadPostListener)

            clearMemory()
            progressDialog.dismiss()
            fragment.clearLayout()
            (fragment.activity as MainActivity).changePage(MainActivity.POSTS)

        } else {
            clearMemory()
            progressDialog.dismiss()
            fragment.clearLayout()
            Toast.makeText(fragment.context, "ERROR", Toast.LENGTH_LONG).show()
        }
    }

    private val uploadPhotoListener = object : TaskListener {
        override fun onSucceed() {
            Log.d("TOMASZ", "PHOTO SUCCESS")
        }

        override fun onFailed() {
            Log.d("TOMASZ", "PHOTO FAIL")
        }
    }

    private val uploadPostListener = object : TaskListener {
        override fun onSucceed() {
            Log.d("TOMASZ", "POST SUCCESS")
        }

        override fun onFailed() {
            Log.d("TOMASZ", "POST FAIL")
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
        post.time = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                .format(Date())

        return post
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