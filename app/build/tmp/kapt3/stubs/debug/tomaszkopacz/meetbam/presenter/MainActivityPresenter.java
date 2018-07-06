package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Ltomaszkopacz/meetbam/presenter/MainActivityPresenter;", "", "activity", "Ltomaszkopacz/meetbam/view/MainActivity;", "(Ltomaszkopacz/meetbam/view/MainActivity;)V", "mLoginService", "Ltomaszkopacz/meetbam/service/LoginService;", "commitPhoto", "", "image", "Ljava/io/File;", "createImage", "galleryFolder", "getImageGallery", "logout", "takePhoto", "service", "Ltomaszkopacz/meetbam/service/CameraService;", "app_debug"})
public final class MainActivityPresenter {
    private tomaszkopacz.meetbam.service.LoginService mLoginService;
    private final tomaszkopacz.meetbam.view.MainActivity activity = null;
    
    public final void logout() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File takePhoto(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.service.CameraService service) {
        return null;
    }
    
    public final void commitPhoto(@org.jetbrains.annotations.NotNull()
    java.io.File image) {
    }
    
    private final java.io.File createImage(java.io.File galleryFolder) {
        return null;
    }
    
    private final java.io.File getImageGallery() {
        return null;
    }
    
    public MainActivityPresenter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.view.MainActivity activity) {
        super();
    }
}