package tomaszkopacz.meetbam.service

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore

import java.io.File

object CameraService {

    fun getCameraIntent(file: File): Intent {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val uri = Uri.fromFile(file)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri!!)

        return cameraIntent
    }
}
