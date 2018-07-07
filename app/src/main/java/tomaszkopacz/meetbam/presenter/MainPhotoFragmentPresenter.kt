package tomaszkopacz.meetbam.presenter

import android.os.Environment
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.service.CameraService
import tomaszkopacz.meetbam.view.MainPhotoFragment
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MainPhotoFragmentPresenter(private val fragment: MainPhotoFragment) {

    fun takePhoto(service: CameraService) {
        val image = createImage(getImageGallery())
        service.takePhoto(image)

        fragment.setLayout(MainPhotoFragment.PAIR_LAYOUT)
        fragment.loadPhoto(image)
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


    private fun createImage(galleryFolder: File): File {
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
}