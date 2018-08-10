package tomaszkopacz.meetbam.router;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0016\u0019\u0018\u0000 (2\u00020\u0001:\u0002()B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0006\u0010\u001e\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0006\u0010 \u001a\u00020\u001cJ\b\u0010!\u001a\u00020\u001cH\u0002J\u001e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&J\b\u0010\'\u001a\u00020\u001cH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Ltomaszkopacz/meetbam/router/CameraRouter;", "", "context", "Landroid/content/Context;", "textureView", "Landroid/view/TextureView;", "(Landroid/content/Context;Landroid/view/TextureView;)V", "backgroundHandler", "Landroid/os/Handler;", "backgroundThread", "Landroid/os/HandlerThread;", "cameraCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "cameraId", "", "captureRequestBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "imageDimension", "Landroid/util/Size;", "stateCallback", "tomaszkopacz/meetbam/router/CameraRouter$stateCallback$1", "Ltomaszkopacz/meetbam/router/CameraRouter$stateCallback$1;", "surfaceListener", "tomaszkopacz/meetbam/router/CameraRouter$surfaceListener$1", "Ltomaszkopacz/meetbam/router/CameraRouter$surfaceListener$1;", "createCameraPreview", "", "openCamera", "start", "startBackgroundThread", "stop", "stopBackgroundThread", "takePicture", "file", "Ljava/io/File;", "listener", "Ltomaszkopacz/meetbam/router/CameraRouter$PhotoStateListener;", "updatePreview", "Companion", "PhotoStateListener", "app_debug"})
public final class CameraRouter {
    private java.lang.String cameraId;
    private android.hardware.camera2.CameraDevice cameraDevice;
    private android.hardware.camera2.CameraCaptureSession cameraCaptureSession;
    private android.hardware.camera2.CaptureRequest.Builder captureRequestBuilder;
    private android.util.Size imageDimension;
    private android.os.Handler backgroundHandler;
    private android.os.HandlerThread backgroundThread;
    private final android.view.TextureView.SurfaceTextureListener surfaceListener = null;
    private final android.hardware.camera2.CameraDevice.StateCallback stateCallback = null;
    private final android.content.Context context = null;
    private final android.view.TextureView textureView = null;
    private static final int REQUEST_CAMERA_PERMISSION = 200;
    public static final tomaszkopacz.meetbam.router.CameraRouter.Companion Companion = null;
    
    public final void start() {
    }
    
    public final void stop() {
    }
    
    public final void takePicture(@org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.router.CameraRouter.PhotoStateListener listener) {
    }
    
    private final void openCamera() {
    }
    
    private final void createCameraPreview() {
    }
    
    private final void updatePreview() {
    }
    
    private final void startBackgroundThread() {
    }
    
    private final void stopBackgroundThread() {
    }
    
    public CameraRouter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.view.TextureView textureView) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Ltomaszkopacz/meetbam/router/CameraRouter$PhotoStateListener;", "", "onError", "", "onPhotoInProgress", "onPhotoTaken", "app_debug"})
    public static abstract interface PhotoStateListener {
        
        public abstract void onPhotoInProgress();
        
        public abstract void onPhotoTaken();
        
        public abstract void onError();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Ltomaszkopacz/meetbam/router/CameraRouter$Companion;", "", "()V", "REQUEST_CAMERA_PERMISSION", "", "getREQUEST_CAMERA_PERMISSION", "()I", "app_debug"})
    public static final class Companion {
        
        public final int getREQUEST_CAMERA_PERMISSION() {
            return 0;
        }
        
        private Companion() {
            super();
        }
    }
}