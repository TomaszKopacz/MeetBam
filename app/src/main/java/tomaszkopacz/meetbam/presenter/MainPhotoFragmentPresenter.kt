package tomaszkopacz.meetbam.presenter

import android.os.Environment
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.Post
import tomaszkopacz.meetbam.interactor.AuthService
import tomaszkopacz.meetbam.interactor.DatabaseService
import tomaszkopacz.meetbam.router.CameraRouter
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.MainPhotoFragment
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MainPhotoFragmentPresenter(private val fragment: MainPhotoFragment) {

    @Inject lateinit var authService: AuthService
    @Inject lateinit var databaseService: DatabaseService
    private var currentImageFile : File? = null
    private var loggedUser: String? = null
    private var pairedUser: String? = null

    init {
        (fragment.activity!!.application as MainApp).component!!.inject(this)
    }

    fun takePhoto(camera: CameraRouter) {
        currentImageFile = createImageFile(getImageGallery())
        camera.takePicture(currentImageFile!!, fragment.context!!, photoListener)
    }

    fun dismissPhoto() {
        /*
             REMOVE IMAGE FROM DIRECTORY
         */
        fragment.photoDismissed()
    }

    fun pair() {
        fragment.startPairing()
        loggedUser = authService.getCurrentUser()!!.displayName
        pairedUser = "Zbyszek Wodecki"
        fragment.paired(loggedUser!!, pairedUser!!)
    }

    fun acceptPhoto() {
        fragment.startPostUploading()

        val me = authService.getCurrentUser()!!.displayName
        val friend = pairedUser
        val url = "SAMPLE URL"
        val time  = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
                .format(Date())

        if (me == null || friend == null || time.isEmpty() || url.isEmpty()) {
            fragment.uploadFailed()
            return

        } else {
            val post = Post()
            post.name1 = me
            post.name2 = friend
            post.photo_dir = url
            post.time = time

            databaseService.putPost(post)
        }

        fragment.uploadDone()
    }


    private fun createImageFile(galleryFolder: File): File {
        val uniqueFileName = SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault())
                .format(Date())

        return File.createTempFile(uniqueFileName, ".jpg", galleryFolder)
    }

    private fun getImageGallery() : File {
        val storageDir
                = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val galleryFolder = File(storageDir, fragment.resources.getString(R.string.app_name))

        if (!galleryFolder.exists()){
            galleryFolder.mkdirs()
        }

        return galleryFolder
    }

    private val photoListener = object : CameraRouter.PhotoStateListener {
        override fun onPhotoInProgress() {
            fragment.startTakingPhoto()
        }

        override fun onPhotoTaken() {
            fragment.photoTaken(currentImageFile!!)
        }

        override fun onError() {

        }
    }
}