package tomaszkopacz.meetbam.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u001e\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020!H\u0002J\b\u0010\'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020!H\u0002J\u0006\u0010,\u001a\u00020!J\u0006\u0010-\u001a\u00020!J\u0006\u0010.\u001a\u00020!J\b\u0010/\u001a\u00020!H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Ltomaszkopacz/meetbam/service/CameraService;", "", "context", "Landroid/content/Context;", "textureView", "Landroid/view/TextureView;", "(Landroid/content/Context;Landroid/view/TextureView;)V", "backgroundHandler", "Landroid/os/Handler;", "backgroundThread", "Landroid/os/HandlerThread;", "cameraCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "cameraFacing", "", "cameraID", "", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "captureRequest", "Landroid/hardware/camera2/CaptureRequest;", "captureRequestBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "previewSize", "Landroid/util/Size;", "stateCallback", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "surfaceTextureListener", "tomaszkopacz/meetbam/service/CameraService$surfaceTextureListener$1", "Ltomaszkopacz/meetbam/service/CameraService$surfaceTextureListener$1;", "closeBackgroundThread", "", "closeCamera", "createImage", "Ljava/io/File;", "galleryFolder", "createPreviewSession", "getImageGallery", "lock", "openBackgroundThread", "openCamera", "setUpCamera", "start", "stop", "takePhoto", "unlock", "app_debug"})
public final class CameraService {
    private final android.hardware.camera2.CameraManager cameraManager = null;
    private java.lang.String cameraID;
    private android.hardware.camera2.CameraDevice cameraDevice;
    private final int cameraFacing = 1;
    private android.util.Size previewSize;
    private android.hardware.camera2.CaptureRequest.Builder captureRequestBuilder;
    private android.hardware.camera2.CaptureRequest captureRequest;
    private android.hardware.camera2.CameraCaptureSession cameraCaptureSession;
    private android.os.HandlerThread backgroundThread;
    private android.os.Handler backgroundHandler;
    private final android.view.TextureView.SurfaceTextureListener surfaceTextureListener = null;
    private final android.hardware.camera2.CameraDevice.StateCallback stateCallback = null;
    private final android.content.Context context = null;
    private final android.view.TextureView textureView = null;
    
    public final void start() {
    }
    
    public final void takePhoto() {
    }
    
    public final void stop() {
    }
    
    private final void openBackgroundThread() {
    }
    
    private final void closeBackgroundThread() {
    }
    
    private final void setUpCamera() {
    }
    
    private final void openCamera() {
    }
    
    private final void closeCamera() {
    }
    
    private final void createPreviewSession() {
    }
    
    private final java.io.File getImageGallery() {
        return null;
    }
    
    private final java.io.File createImage(java.io.File galleryFolder) {
        return null;
    }
    
    private final void lock() {
    }
    
    private final void unlock() {
    }
    
    public CameraService(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.view.TextureView textureView) {
        super();
    }
}