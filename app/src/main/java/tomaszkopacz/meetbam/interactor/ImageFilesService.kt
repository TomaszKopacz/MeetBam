package tomaszkopacz.meetbam.interactor

import android.os.Environment
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class ImageFilesService {

    companion object {
        const val IMAGES_FOLDER = "MeetBam"
        const val PROFILE_PHOTO_FOLDER = "profile"
        const val POST_PHOTO_FOLDER = "posts"
    }

    private fun getPostImageGallery(): File {
        val storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val galleryFolder = File(storageDir, "$IMAGES_FOLDER/$POST_PHOTO_FOLDER")

        if (!galleryFolder.exists()) {
            galleryFolder.mkdirs()
        }

        return galleryFolder
    }

    private fun getProfileImageGallery(): File {
        val storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val galleryFolder = File(storageDir, "$IMAGES_FOLDER/$PROFILE_PHOTO_FOLDER")

        if (!galleryFolder.exists()) {
            galleryFolder.mkdirs()
        }

        return galleryFolder
    }

    private fun getUniqueFileName(): String {
        return SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(Date())
    }

    fun createPostImageFile(): File {
        return File(getPostImageGallery(), "${getUniqueFileName()}.png")
    }

    fun createProfileImageFile(): File{
        return File(getProfileImageGallery(), "${getUniqueFileName()}.png")
    }
}