package tomaszkopacz.meetbam.presenter

import android.content.Intent
import android.hardware.Camera
import android.os.Environment
import tomaszkopacz.meetbam.service.LoginService
import tomaszkopacz.meetbam.view.LoginActivity
import tomaszkopacz.meetbam.view.MainActivity
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*


class MainActivityPresenter(private val activity: MainActivity) : Camera.PictureCallback {

    private var mLoginService = LoginService(activity.applicationContext)

    companion object {
        private val PHOTO_DIRECTORY = Environment.getExternalStoragePublicDirectory(Environment
                .DIRECTORY_PICTURES).toString() + "/Meetbam/"
    }

    fun logout() {
        mLoginService.logout()

        val intent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    override fun onPictureTaken(data: ByteArray?, camera: Camera?) {
        val photoFileName = createUniquePhotoName()
        val photoFile = createPhotoFile(PHOTO_DIRECTORY, photoFileName)

        try {
            val fos = FileOutputStream(photoFile)
            fos.write(data)
            fos.close()

        } catch (e: Exception){

        }
    }

    private fun createUniquePhotoName() : String{
        return SimpleDateFormat("yyyyMMddhhmmssSSSS", Locale.US).format(Date()) + ".jpg"
    }

    private fun createPhotoFile(directory: String, fileName: String): File {

        val path = File(directory)
        path.mkdirs()

        val dir = directory + fileName
        val file = File(dir)
        file.createNewFile()

        return file
    }
}