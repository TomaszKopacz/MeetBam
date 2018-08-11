package tomaszkopacz.meetbam.presenter

import android.os.Environment
import com.google.firebase.auth.FirebaseAuth
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.Post
import tomaszkopacz.meetbam.router.CameraRouter
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.MainPhotoFragment
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MainPhotoFragmentPresenter(private val fragment: MainPhotoFragment) {

    @Inject lateinit var auth: FirebaseAuth
    var currentImageFile : File? = null
    var currentUserPaired: String? = null

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
        currentUserPaired = "Zbyszek Wodecki"
        fragment.paired(currentUserPaired!!)
    }

    fun acceptPhoto() {
        fragment.startPostUploading()

        val me = auth.currentUser?.displayName
        val friend = currentUserPaired
        val post = Post()

        if (me == null || friend == null) {
            fragment.uploadFailed()
            return

        } else {
            post.name1 = me
            post.name2 = friend
            post.photo_dir = "SAMPLE DIR"
            post.time = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
                    .format(Date())
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