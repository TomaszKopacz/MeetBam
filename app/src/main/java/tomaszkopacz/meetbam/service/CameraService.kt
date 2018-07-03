package tomaszkopacz.meetbam.service

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.hardware.Camera
import android.net.Uri
import android.provider.MediaStore
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.io.File

object CameraService {

    fun getCameraInstance() : Camera {
        return Camera.open()
    }

    @Suppress("DEPRECATION")
    @SuppressLint("ViewConstructor")
    class CameraPreview(context: Context, private val camera: Camera)
        : SurfaceView(context), SurfaceHolder.Callback {

        init {
            val holder = holder
            holder.addCallback(this)
            holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
        }

        override fun surfaceCreated(holder: SurfaceHolder?) {
            camera.setDisplayOrientation(90)
            camera.setPreviewDisplay(holder)
            camera.startPreview()
        }

        override fun surfaceDestroyed(holder: SurfaceHolder?) {
        }

        override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        }
    }

    fun getCameraIntent(file: File): Intent {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val uri = Uri.fromFile(file)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri!!)

        return cameraIntent
    }
}
