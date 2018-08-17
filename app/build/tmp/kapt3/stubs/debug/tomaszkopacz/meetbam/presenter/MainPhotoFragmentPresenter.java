package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0003\u001d(+\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u000203H\u0002J\u0006\u00104\u001a\u00020.J\b\u00105\u001a\u000200H\u0002J\u0006\u00106\u001a\u00020.J\u000e\u00107\u001a\u00020.2\u0006\u00108\u001a\u000209R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010\'\u001a\u00020(X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u00020+X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010,\u00a8\u0006:"}, d2 = {"Ltomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter;", "", "fragment", "Ltomaszkopacz/meetbam/view/MainPhotoFragment;", "(Ltomaszkopacz/meetbam/view/MainPhotoFragment;)V", "authService", "Ltomaszkopacz/meetbam/interactor/AuthService;", "getAuthService", "()Ltomaszkopacz/meetbam/interactor/AuthService;", "setAuthService", "(Ltomaszkopacz/meetbam/interactor/AuthService;)V", "currentImageFile", "Ljava/io/File;", "databaseService", "Ltomaszkopacz/meetbam/interactor/DatabaseService;", "getDatabaseService", "()Ltomaszkopacz/meetbam/interactor/DatabaseService;", "setDatabaseService", "(Ltomaszkopacz/meetbam/interactor/DatabaseService;)V", "imageFilesService", "Ltomaszkopacz/meetbam/interactor/ImageFilesService;", "getImageFilesService", "()Ltomaszkopacz/meetbam/interactor/ImageFilesService;", "setImageFilesService", "(Ltomaszkopacz/meetbam/interactor/ImageFilesService;)V", "loggedUser", "", "pairedUser", "photoListener", "tomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$photoListener$1", "Ltomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$photoListener$1;", "progressDialog", "Ltomaszkopacz/meetbam/dialogs/ProgressDialog;", "storageService", "Ltomaszkopacz/meetbam/interactor/StorageService;", "getStorageService", "()Ltomaszkopacz/meetbam/interactor/StorageService;", "setStorageService", "(Ltomaszkopacz/meetbam/interactor/StorageService;)V", "uploadPhotoListener", "tomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$uploadPhotoListener$1", "Ltomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$uploadPhotoListener$1;", "uploadPostListener", "tomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$uploadPostListener$1", "Ltomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$uploadPostListener$1;", "acceptPhoto", "", "areUsersAvailable", "", "clearMemory", "createPost", "Ltomaszkopacz/meetbam/entity/Post;", "dismissPhoto", "isImageAvailable", "pair", "takePhoto", "camera", "Ltomaszkopacz/meetbam/router/CameraRouter;", "app_debug"})
public final class MainPhotoFragmentPresenter {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.AuthService authService;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.DatabaseService databaseService;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.StorageService storageService;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.ImageFilesService imageFilesService;
    private java.io.File currentImageFile;
    private java.lang.String loggedUser;
    private java.lang.String pairedUser;
    private final tomaszkopacz.meetbam.dialogs.ProgressDialog progressDialog = null;
    private final tomaszkopacz.meetbam.interactor.TaskListener uploadPhotoListener = null;
    private final tomaszkopacz.meetbam.interactor.TaskListener uploadPostListener = null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.StorageService getStorageService() {
        return null;
    }
    
    public final void setStorageService(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.StorageService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.ImageFilesService getImageFilesService() {
        return null;
    }
    
    public final void setImageFilesService(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.ImageFilesService p0) {
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
    
    private final boolean areUsersAvailable() {
        return false;
    }
    
    private final boolean isImageAvailable() {
        return false;
    }
    
    private final tomaszkopacz.meetbam.entity.Post createPost() {
        return null;
    }
    
    private final void clearMemory() {
    }
    
    public MainPhotoFragmentPresenter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.view.MainPhotoFragment fragment) {
        super();
    }
}