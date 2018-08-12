package tomaszkopacz.meetbam.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016\u00a2\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\u001a\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0016\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0016J\u0006\u0010 \u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020\u0010H\u0002J\u0006\u0010\'\u001a\u00020\u0010J\u0006\u0010(\u001a\u00020\u0010J\u0006\u0010)\u001a\u00020\u0010J\b\u0010*\u001a\u00020\u0010H\u0002J\u0006\u0010+\u001a\u00020\u0010J\u0006\u0010,\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Ltomaszkopacz/meetbam/view/MainPhotoFragment;", "Landroid/support/v4/app/Fragment;", "()V", "cameraService", "Ltomaszkopacz/meetbam/router/CameraRouter;", "presenter", "Ltomaszkopacz/meetbam/presenter/MainPhotoFragmentPresenter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onViewCreated", "view", "paired", "loggedUser", "pairedUser", "photoDismissed", "photoTaken", "directory", "Ljava/io/File;", "setLayout", "layout", "showProgress", "startPairing", "startPostUploading", "startTakingPhoto", "stopProgress", "uploadDone", "uploadFailed", "Companion", "app_debug"})
public final class MainPhotoFragment extends android.support.v4.app.Fragment {
    private tomaszkopacz.meetbam.presenter.MainPhotoFragmentPresenter presenter;
    private tomaszkopacz.meetbam.router.CameraRouter cameraService;
    public static final int MAKE_PHOTO_LAYOUT = 1;
    public static final int ACCEPT_PHOTO_LAYOUT = 3;
    public static final tomaszkopacz.meetbam.view.MainPhotoFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void setLayout(int layout) {
    }
    
    private final void showProgress() {
    }
    
    private final void stopProgress() {
    }
    
    public final void startTakingPhoto() {
    }
    
    public final void photoTaken(@org.jetbrains.annotations.NotNull()
    java.io.File directory) {
    }
    
    public final void photoDismissed() {
    }
    
    public final void startPairing() {
    }
    
    public final void paired(@org.jetbrains.annotations.NotNull()
    java.lang.String loggedUser, @org.jetbrains.annotations.NotNull()
    java.lang.String pairedUser) {
    }
    
    public final void startPostUploading() {
    }
    
    public final void uploadFailed() {
    }
    
    public final void uploadDone() {
    }
    
    public MainPhotoFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Ltomaszkopacz/meetbam/view/MainPhotoFragment$Companion;", "", "()V", "ACCEPT_PHOTO_LAYOUT", "", "MAKE_PHOTO_LAYOUT", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}