package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000*\u0001\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u0006\u0010\u001d\u001a\u00020\u001aJ\b\u0010\u001e\u001a\u00020\fH\u0002J\u0006\u0010\u001f\u001a\u00020\u001aJ\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0018\u00a8\u0006#"}, d2 = {"Ltomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter;", "", "fragment", "Ltomaszkopacz/meetbam/view/MainPhotoFragment;", "(Ltomaszkopacz/meetbam/view/MainPhotoFragment;)V", "authService", "Ltomaszkopacz/meetbam/interactor/AuthService;", "getAuthService", "()Ltomaszkopacz/meetbam/interactor/AuthService;", "setAuthService", "(Ltomaszkopacz/meetbam/interactor/AuthService;)V", "currentImageFile", "Ljava/io/File;", "databaseService", "Ltomaszkopacz/meetbam/interactor/DatabaseService;", "getDatabaseService", "()Ltomaszkopacz/meetbam/interactor/DatabaseService;", "setDatabaseService", "(Ltomaszkopacz/meetbam/interactor/DatabaseService;)V", "loggedUser", "", "pairedUser", "photoListener", "tomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$photoListener$1", "Ltomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$photoListener$1;", "acceptPhoto", "", "createImageFile", "galleryFolder", "dismissPhoto", "getImageGallery", "pair", "takePhoto", "camera", "Ltomaszkopacz/meetbam/router/CameraRouter;", "app_debug"})
public final class MainPhotoFragmentPresenter {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.AuthService authService;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.DatabaseService databaseService;
    private java.io.File currentImageFile;
    private java.lang.String loggedUser;
    private java.lang.String pairedUser;
    private final tomaszkopacz.meetbam.router.CameraRouter.PhotoStateListener photoListener = null;
    private final tomaszkopacz.meetbam.view.MainPhotoFragment fragment = null;
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.AuthService getAuthService() {
        return null;
    }
    
    public final void setAuthService(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.AuthService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.DatabaseService getDatabaseService() {
        return null;
    }
    
    public final void setDatabaseService(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.DatabaseService p0) {
    }
    
    public final void takePhoto(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.router.CameraRouter camera) {
    }
    
    public final void dismissPhoto() {
    }
    
    public final void pair() {
    }
    
    public final void acceptPhoto() {
    }
    
    private final java.io.File createImageFile(java.io.File galleryFolder) {
        return null;
    }
    
    private final java.io.File getImageGallery() {
        return null;
    }
    
    public MainPhotoFragmentPresenter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.view.MainPhotoFragment fragment) {
        super();
    }
}