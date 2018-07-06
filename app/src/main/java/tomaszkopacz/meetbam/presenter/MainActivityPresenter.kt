package tomaszkopacz.meetbam.presenter

import android.content.Intent
import android.os.Environment
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.service.CameraService
import tomaszkopacz.meetbam.service.LoginService
import tomaszkopacz.meetbam.view.LoginActivity
import tomaszkopacz.meetbam.view.MainActivity
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


class MainActivityPresenter(private val activity: MainActivity){

    private var mLoginService = LoginService(activity.applicationContext)
    fun logout() {
        mLoginService.logout()

        val intent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    fun takePhoto(service: CameraService) : File {
        val image = createImage(getImageGallery())
        service.takePhoto(image)

        return image
    }



    fun commitPhoto(image: File){

    }

    private fun createImage(galleryFolder: File): File {
        val uniqueFileName = SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault())
                .format(Date())

        return File.createTempFile(uniqueFileName, ".jpg", galleryFolder)
    }

    private fun getImageGallery() : File {
        val storageDir
                = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val galleryFolder = File(storageDir, activity.resources.getString(R.string.app_name))

        if (!galleryFolder.exists()){
            galleryFolder.mkdirs()
        }

        return galleryFolder
    }
}