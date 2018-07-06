package tomaszkopacz.meetbam.service

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.SurfaceTexture
import android.hardware.camera2.*
import android.os.Environment
import android.os.Handler
import android.os.HandlerThread
import android.support.v4.app.ActivityCompat
import android.util.Size
import android.view.Surface
import android.view.TextureView
import tomaszkopacz.meetbam.R
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class CameraService(private val context: Context, private val textureView: TextureView){

    private val cameraManager: CameraManager
            = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager

    private var cameraID: String? = null
    private var cameraDevice: CameraDevice? = null

    private val cameraFacing = CameraCharacteristics.LENS_FACING_BACK
    private var previewSize: Size? = null
    private var captureRequestBuilder: CaptureRequest.Builder? = null
    private var captureRequest: CaptureRequest? = null
    private var cameraCaptureSession: CameraCaptureSession? = null

    private var backgroundThread: HandlerThread? = null
    private var backgroundHandler: Handler? = null


    /*==============================================================================================
                                        VIEW LISTENER
     =============================================================================================*/

    private val surfaceTextureListener = object : TextureView.SurfaceTextureListener{
        override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture?, width: Int, height: Int) {
        }

        override fun onSurfaceTextureUpdated(surface: SurfaceTexture?) {
        }

        override fun onSurfaceTextureDestroyed(surface: SurfaceTexture?): Boolean {
            return false
        }

        override fun onSurfaceTextureAvailable(surface: SurfaceTexture?, width: Int, height: Int) {
            setUpCamera()
            openCamera()
        }
    }

    /*==============================================================================================
                                       CAMERA CALLBACK
     =============================================================================================*/

    private val stateCallback: CameraDevice.StateCallback = object : CameraDevice.StateCallback(){
        override fun onOpened(camera: CameraDevice?) {
            cameraDevice = camera
            createPreviewSession()
        }

        override fun onDisconnected(camera: CameraDevice?) {
            cameraDevice!!.close()
            cameraDevice = null
        }

        override fun onError(camera: CameraDevice?, error: Int) {
            cameraDevice!!.close()
            cameraDevice = null
        }

    }

    /*==============================================================================================
                                            PUBLIC METHODS
     =============================================================================================*/

    fun start(){
        openBackgroundThread()
        if (textureView.isAvailable){
            setUpCamera()
            openCamera()

        } else {
            textureView.surfaceTextureListener = surfaceTextureListener
        }
    }

    fun takePhoto(){
        lock()
        var fos: FileOutputStream? = null

        try {
            fos = FileOutputStream(createImage(getImageGallery()))
            textureView.bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)

        } catch (e: Exception) {

        } finally {
            fos!!.close()
            unlock()
        }
    }

    fun stop(){
        closeCamera()
        closeBackgroundThread()
    }

    /*==============================================================================================
                                            PRIVATE METHODS
     =============================================================================================*/

    private fun openBackgroundThread(){
        backgroundThread = HandlerThread("camera_background_thread")
        backgroundThread!!.start()
        backgroundHandler = android.os.Handler(backgroundThread!!.looper)
    }

    private fun closeBackgroundThread(){
        if (backgroundHandler != null){
            backgroundThread!!.quitSafely()
            backgroundThread = null
            backgroundHandler = null
        }
    }

    private fun setUpCamera(){
        try {
            for (cameraID in cameraManager.cameraIdList){
                val cameraCharacteristic: CameraCharacteristics
                        = cameraManager.getCameraCharacteristics(cameraID)

                if (cameraCharacteristic.get(CameraCharacteristics.LENS_FACING) == cameraFacing){
                    val config = cameraCharacteristic.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)
                    val previewSize: Size = config!!.getOutputSizes(SurfaceTexture::class.java)[0]

                    this.cameraID = cameraID
                    this.previewSize = previewSize
                }
            }

        } catch (e: Exception){ }
    }

    private fun openCamera(){
        try {
            if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED)
                cameraManager.openCamera(cameraID, stateCallback, backgroundHandler)

        } catch (e: Exception){ }
    }

    private fun closeCamera(){
        if (cameraCaptureSession != null){
            cameraCaptureSession!!.close()
            cameraCaptureSession = null
        }

        if (cameraDevice != null){
            cameraDevice!!.close()
            cameraDevice = null
        }
    }

    private fun createPreviewSession(){
        try {
            val surfaceTexture = textureView.surfaceTexture
            surfaceTexture.setDefaultBufferSize(previewSize!!.width, previewSize!!.height)
            val previewSurface = Surface(surfaceTexture)
            captureRequestBuilder = cameraDevice!!
                    .createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW)
            captureRequestBuilder!!.addTarget(previewSurface)

            cameraDevice!!.createCaptureSession(Collections.singletonList(previewSurface),
                    object : CameraCaptureSession.StateCallback(){
                        override fun onConfigureFailed(session: CameraCaptureSession?) {
                        }

                        override fun onConfigured(session: CameraCaptureSession?) {
                            if (cameraDevice == null)
                                return

                            try {
                                captureRequest = captureRequestBuilder!!.build()
                                cameraCaptureSession = session
                                cameraCaptureSession!!.setRepeatingRequest(captureRequest,
                                        null, backgroundHandler)

                            } catch (e: Exception) {

                            }
                        }

                    }, backgroundHandler)

        } catch (e: Exception) {

        }
    }

    private fun getImageGallery() : File{
        val storageDir
                = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val galleryFolder = File(storageDir, context.resources.getString(R.string.app_name))

        if (!galleryFolder.exists()){
            galleryFolder.mkdirs()
        }

        return galleryFolder
    }

    private fun createImage(galleryFolder: File): File{
        val uniqueFileName = SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault())
                .format(Date())

        return File.createTempFile(uniqueFileName, ".jpg", galleryFolder)
    }

    private fun lock(){
        try {
            cameraCaptureSession!!.capture(captureRequestBuilder!!.build(),
                    null, backgroundHandler)

        } catch (e: Exception) {

        }
    }

    private fun unlock(){
        try {
            cameraCaptureSession!!.setRepeatingRequest(captureRequestBuilder!!.build(),
                    null, backgroundHandler)

        } catch (e: Exception){

        }
    }
}
