package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0002\u0014\u001f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020\"J\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\'R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010 \u00a8\u0006("}, d2 = {"Ltomaszkopacz/meetbam/presenter/PersonPhotoFragmentPresenter;", "", "fragment", "Ltomaszkopacz/meetbam/view/PersonPhotoFragment;", "(Ltomaszkopacz/meetbam/view/PersonPhotoFragment;)V", "auth", "Ltomaszkopacz/meetbam/interactor/AuthService;", "getAuth", "()Ltomaszkopacz/meetbam/interactor/AuthService;", "setAuth", "(Ltomaszkopacz/meetbam/interactor/AuthService;)V", "imageFile", "Ljava/io/File;", "imageFilesService", "Ltomaszkopacz/meetbam/interactor/ImageFilesService;", "getImageFilesService", "()Ltomaszkopacz/meetbam/interactor/ImageFilesService;", "setImageFilesService", "(Ltomaszkopacz/meetbam/interactor/ImageFilesService;)V", "photoListener", "tomaszkopacz/meetbam/presenter/PersonPhotoFragmentPresenter$photoListener$1", "Ltomaszkopacz/meetbam/presenter/PersonPhotoFragmentPresenter$photoListener$1;", "progressDialog", "Ltomaszkopacz/meetbam/dialogs/ProgressDialog;", "storage", "Ltomaszkopacz/meetbam/interactor/StorageService;", "getStorage", "()Ltomaszkopacz/meetbam/interactor/StorageService;", "setStorage", "(Ltomaszkopacz/meetbam/interactor/StorageService;)V", "uploadPhotoListener", "tomaszkopacz/meetbam/presenter/PersonPhotoFragmentPresenter$uploadPhotoListener$1", "Ltomaszkopacz/meetbam/presenter/PersonPhotoFragmentPresenter$uploadPhotoListener$1;", "acceptPhoto", "", "dismissPhoto", "skip", "takePhoto", "camera", "Ltomaszkopacz/meetbam/router/CameraRouter;", "app_debug"})
public final class PersonPhotoFragmentPresenter {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.ImageFilesService imageFilesService;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.StorageService storage;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.AuthService auth;
    private java.io.File imageFile;
    private final tomaszkopacz.meetbam.dialogs.ProgressDialog progressDialog = null;
    private final tomaszkopacz.meetbam.router.CameraRouter.PhotoStateListener photoListener = null;
    private final tomaszkopacz.meetbam.interactor.TaskListener uploadPhotoListener = null;
    private final tomaszkopacz.meetbam.view.PersonPhotoFragment fragment = null;
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.ImageFilesService getImageFilesService() {
        return null;
    }
    
    public final void setImageFilesService(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.ImageFilesService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.StorageService getStorage() {
        return null;
    }
    
    public final void setStorage(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.StorageService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.AuthService getAuth() {
        return null;
    }
    
    public final void setAuth(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.AuthService p0) {
    }
    
    public final void skip() {
    }
    
    public final void takePhoto(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.router.CameraRouter camera) {
    }
    
    public final void dismissPhoto() {
    }
    
    public final void acceptPhoto() {
    }
    
    public PersonPhotoFragmentPresenter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.view.PersonPhotoFragment fragment) {
        super();
    }
}