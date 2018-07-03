package tomaszkopacz.meetbam.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\n"}, d2 = {"Ltomaszkopacz/meetbam/service/CameraService;", "", "()V", "getCameraInstance", "Landroid/hardware/Camera;", "getCameraIntent", "Landroid/content/Intent;", "file", "Ljava/io/File;", "CameraPreview", "app_debug"})
public final class CameraService {
    public static final tomaszkopacz.meetbam.service.CameraService INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.hardware.Camera getCameraInstance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Intent getCameraIntent(@org.jetbrains.annotations.NotNull()
    java.io.File file) {
        return null;
    }
    
    private CameraService() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J*\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Ltomaszkopacz/meetbam/service/CameraService$CameraPreview;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "context", "Landroid/content/Context;", "camera", "Landroid/hardware/Camera;", "(Landroid/content/Context;Landroid/hardware/Camera;)V", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "app_debug"})
    public static final class CameraPreview extends android.view.SurfaceView implements android.view.SurfaceHolder.Callback {
        private final android.hardware.Camera camera = null;
        private java.util.HashMap _$_findViewCache;
        
        @java.lang.Override()
        public void surfaceCreated(@org.jetbrains.annotations.Nullable()
        android.view.SurfaceHolder holder) {
        }
        
        @java.lang.Override()
        public void surfaceDestroyed(@org.jetbrains.annotations.Nullable()
        android.view.SurfaceHolder holder) {
        }
        
        @java.lang.Override()
        public void surfaceChanged(@org.jetbrains.annotations.Nullable()
        android.view.SurfaceHolder holder, int format, int width, int height) {
        }
        
        public CameraPreview(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.hardware.Camera camera) {
            super(null);
        }
    }
}