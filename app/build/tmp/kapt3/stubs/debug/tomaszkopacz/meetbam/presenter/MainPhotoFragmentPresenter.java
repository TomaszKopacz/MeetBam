package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0003\u0017\"%\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\'\u001a\u00020(J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fH\u0002J\b\u0010.\u001a\u00020/H\u0002J\u0006\u00100\u001a\u00020(J\b\u00101\u001a\u00020\fH\u0002J\b\u00102\u001a\u00020*H\u0002J\u0006\u00103\u001a\u00020(J\u000e\u00104\u001a\u00020(2\u0006\u00105\u001a\u000206R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u00020%X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010&\u00a8\u00067"}, d2 = {"Ltomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter;", "", "fragment", "Ltomaszkopacz/meetbam/view/MainPhotoFragment;", "(Ltomaszkopacz/meetbam/view/MainPhotoFragment;)V", "authService", "Ltomaszkopacz/meetbam/interactor/AuthService;", "getAuthService", "()Ltomaszkopacz/meetbam/interactor/AuthService;", "setAuthService", "(Ltomaszkopacz/meetbam/interactor/AuthService;)V", "currentImageFile", "Ljava/io/File;", "databaseService", "Ltomaszkopacz/meetbam/interactor/DatabaseService;", "getDatabaseService", "()Ltomaszkopacz/meetbam/interactor/DatabaseService;", "setDatabaseService", "(Ltomaszkopacz/meetbam/interactor/DatabaseService;)V", "loggedUser", "", "pairedUser", "photoListener", "tomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$photoListener$1", "Ltomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$photoListener$1;", "progressDialog", "Ltomaszkopacz/meetbam/dialogs/ProgressDialog;", "storageService", "Ltomaszkopacz/meetbam/interactor/StorageService;", "getStorageService", "()Ltomaszkopacz/meetbam/interactor/StorageService;", "setStorageService", "(Ltomaszkopacz/meetbam/interactor/StorageService;)V", "uploadPhotoListener", "tomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$uploadPhotoListener$1", "Ltomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$uploadPhotoListener$1;", "uploadPostListener", "tomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$uploadPostListener$1", "Ltomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter$uploadPostListener$1;", "acceptPhoto", "", "areUsersAvailable", "", "clearMemory", "createImageFile", "galleryFolder", "createPost", "Ltomaszkopacz/meetbam/entity/Post;", "dismissPhoto", "getImageGallery", "isImageAvailable", "pair", "takePhoto", "camera", "Ltomaszkopacz/meetbam/router/CameraRouter;", "app_debug"})
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
    
    private final java.io.File createImageFile(java.io.File galleryFolder) {
        return null;
    }
    
    private final java.io.File getImageGallery() {
        return null;
    }
    
    private final void clearMemory() {
    }
    
    public MainPhotoFragmentPresenter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.view.MainPhotoFragment fragment) {
        super();
    }
}