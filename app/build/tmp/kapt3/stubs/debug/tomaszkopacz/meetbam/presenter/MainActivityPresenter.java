package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Ltomaszkopacz/meetbam/presenter/MainActivityPresenter;", "Landroid/hardware/Camera$PictureCallback;", "activity", "Ltomaszkopacz/meetbam/view/MainActivity;", "(Ltomaszkopacz/meetbam/view/MainActivity;)V", "mLoginService", "Ltomaszkopacz/meetbam/service/LoginService;", "createPhotoFile", "Ljava/io/File;", "directory", "", "fileName", "createUniquePhotoName", "logout", "", "onPictureTaken", "data", "", "camera", "Landroid/hardware/Camera;", "Companion", "app_debug"})
public final class MainActivityPresenter implements android.hardware.Camera.PictureCallback {
    private tomaszkopacz.meetbam.service.LoginService mLoginService;
    private final tomaszkopacz.meetbam.view.MainActivity activity = null;
    private static final java.lang.String PHOTO_DIRECTORY = null;
    public static final tomaszkopacz.meetbam.presenter.MainActivityPresenter.Companion Companion = null;
    
    public final void logout() {
    }
    
    @java.lang.Override()
    public void onPictureTaken(@org.jetbrains.annotations.Nullable()
    byte[] data, @org.jetbrains.annotations.Nullable()
    android.hardware.Camera camera) {
    }
    
    private final java.lang.String createUniquePhotoName() {
        return null;
    }
    
    private final java.io.File createPhotoFile(java.lang.String directory, java.lang.String fileName) {
        return null;
    }
    
    public MainActivityPresenter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.view.MainActivity activity) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Ltomaszkopacz/meetbam/presenter/MainActivityPresenter$Companion;", "", "()V", "PHOTO_DIRECTORY", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}