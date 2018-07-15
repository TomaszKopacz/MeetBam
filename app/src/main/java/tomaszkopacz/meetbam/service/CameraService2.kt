package tomaszkopacz.meetbam.service

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.SurfaceTexture
import android.hardware.camera2.*
import android.os.Handler
import android.os.HandlerThread
import android.support.v4.app.ActivityCompat
import android.util.Size
import android.view.Surface
import android.view.TextureView
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import java.util.*

class CameraService2(private val context: Context, private val textureView: TextureView) {

    private var cameraId: String? = null
    private var cameraDevice: CameraDevice? = null
    private var cameraCaptureSession: CameraCaptureSession? = null
    private var captureRequestBuilder: CaptureRequest.Builder? = null
    private var imageDimension: Size? = null

    private var backgroundHandler: Handler? = null
    private var backgroundThread: HandlerThread? = null

    companion object {
        val REQUEST_CAMERA_PERMISSION = 200
    }

    private val surfaceListener = object : TextureView.SurfaceTextureListener {
        override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture?, width: Int, height: Int) {

        }

        override fun onSurfaceTextureUpdated(surface: SurfaceTexture?) {
        }

        override fun onSurfaceTextureDestroyed(surface: SurfaceTexture?): Boolean {
            return false
        }

        override fun onSurfaceTextureAvailable(surface: SurfaceTexture?, width: Int, height: Int) {
            openCamera()
        }
    }

    fun start() {
        startBackgroundThread()
        if (textureView.isAvailable) {
            openCamera()
        } else
            textureView.surfaceTextureListener = surfaceListener
    }

    fun stop() {
        stopBackgroundThread()
    }

    fun takePicture(file: File, context: Context, listener: PhotoStateListener) {
        val photoThread = object : Thread() {
            override fun run() {
                var fos: FileOutputStream? = null

                try {
                    fos = FileOutputStream(file)
                    textureView.bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)

                    (context as Activity).runOnUiThread{
                        listener.onPhotoTaken()
                    }

                } catch (e: Exception) {
                    (context as Activity).runOnUiThread{
                        listener.onError()
                    }

                } finally {
                    fos!!.close()
                }
            }
        }

        listener.onPhotoInProgress()
        photoThread.start()
    }

    private fun openCamera() {
        textureView.surfaceTextureListener = surfaceListener
        val manager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager

        try {
            cameraId = manager.cameraIdList[0]
            val characteristics = manager.getCameraCharacteristics(cameraId)
            val map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)
            imageDimension = map.getOutputSizes(SurfaceTexture::class.java)[0]


            if (ActivityCompat.checkSelfPermission(context,
                    android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(android.Manifest.permission.CAMERA,
                                android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        REQUEST_CAMERA_PERMISSION)

                return
            }

            manager.openCamera(cameraId, stateCallback, null)

        } catch (e: Exception) {

        }
    }

    private val stateCallback = object : CameraDevice.StateCallback() {
        override fun onOpened(camera: CameraDevice?) {
            cameraDevice = camera
            createCameraPreview()
        }

        override fun onDisconnected(camera: CameraDevice?) {
            cameraDevice!!.close()
        }

        override fun onError(camera: CameraDevice?, error: Int) {
            cameraDevice!!.close()
            cameraDevice = null
        }
    }

    private fun createCameraPreview() {
        val texture = textureView.surfaceTexture
        texture.setDefaultBufferSize(imageDimension!!.width, imageDimension!!.height)

        val surface = Surface(texture)
        captureRequestBuilder = cameraDevice!!.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW)
        captureRequestBuilder!!.addTarget(surface)

        cameraDevice!!.createCaptureSession(Arrays.asList(surface),
                object : CameraCaptureSession.StateCallback() {
                    override fun onConfigureFailed(session: CameraCaptureSession?) {
                        Toast.makeText(context, "Changed", Toast.LENGTH_LONG).show()
                    }

                    override fun onConfigured(session: CameraCaptureSession?) {
                        if (cameraDevice == null)
                            return

                        cameraCaptureSession = session
                        updatePreview()
                    }

                }, null)
    }

    private fun updatePreview() {
        if (cameraDevice == null)
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()

        captureRequestBuilder!!.set(CaptureRequest.CONTROL_MODE, CaptureRequest.CONTROL_MODE_AUTO)

        try {
            cameraCaptureSession!!.setRepeatingRequest(captureRequestBuilder!!.build(),
                    null, backgroundHandler)

        } catch (e: Exception) {

        }
    }

    private fun startBackgroundThread() {
        backgroundThread = HandlerThread("Camera Background")
        backgroundThread!!.start()

        backgroundHandler = Handler(backgroundThread!!.looper)
    }

    private fun stopBackgroundThread() {
        backgroundThread!!.quitSafely()

        try {
            backgroundThread!!.join()
            backgroundThread = null
            backgroundHandler = null

        } catch (e: Exception) {

        }
    }

    interface PhotoStateListener {
        fun onPhotoInProgress()
        fun onPhotoTaken()
        fun onError()
    }

}