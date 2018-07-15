package tomaszkopacz.meetbam.presenter

import android.os.Environment
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.service.CameraService2
import tomaszkopacz.meetbam.view.MainPhotoFragment
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MainPhotoFragmentPresenter(private val fragment: MainPhotoFragment) {

    var currentImageFile : File? = null

    fun takePhoto(service: CameraService2) {
        currentImageFile = createImageFile(getImageGallery())
        service.takePicture(currentImageFile!!, fragment.context!!, photoListener)
    }

    fun dismissPhoto() {
        /*
             REMOVE IMAGE FROM DIRECTORY
         */
        fragment.setLayout(MainPhotoFragment.MAKE_PHOTO_LAYOUT)
    }

    fun pair() {
        fragment.setLayout(MainPhotoFragment.ACCEPT_PHOTO_LAYOUT)
    }

    fun acceptPhoto() {
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

    private val photoListener = object : CameraService2.PhotoStateListener {
        override fun onPhotoInProgress() {
            fragment.showProgress()
        }

        override fun onPhotoTaken() {
            fragment.setLayout(MainPhotoFragment.ACCEPT_PHOTO_LAYOUT)
            fragment.stopProgress()
            fragment.loadPhoto(currentImageFile!!)
        }

        override fun onError() {

        }
    }
}