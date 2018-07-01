package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001CB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010&\u001a\u00020\'2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010(\u001a\u00020\'2\u0006\u0010)\u001a\u00020\u0016H\u0016J\u0010\u0010*\u001a\u00020\'2\u0006\u0010)\u001a\u00020\u0016H\u0016J\u0006\u0010+\u001a\u00020\'J\b\u0010,\u001a\u00020\u001cH\u0002J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0002J\b\u00102\u001a\u000203H\u0016J\u0006\u00104\u001a\u00020\'J\u0018\u00105\u001a\u00020\'2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000203H\u0016J\u0010\u00109\u001a\u00020\'2\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\'H\u0016J\u000e\u0010=\u001a\u00020\'2\u0006\u0010>\u001a\u00020\u001aJ\u0006\u0010?\u001a\u00020\'J\b\u0010@\u001a\u00020\'H\u0002J\b\u0010A\u001a\u00020\'H\u0002J\u0006\u0010B\u001a\u00020\'R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006D"}, d2 = {"Ltomaszkopacz/meetbam/presenter/MainActivityPresenter;", "Ltomaszkopacz/meetbam/presenter/RecyclerViewPresenter;", "Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialogPresenter;", "Ltomaszkopacz/meetbam/dialogs/ChooseDeviceDialogPresenter;", "Ltomaszkopacz/meetbam/presenter/BluetoothPresenter;", "activity", "Ltomaszkopacz/meetbam/view/MainActivity;", "(Ltomaszkopacz/meetbam/view/MainActivity;)V", "adapter", "Ltomaszkopacz/meetbam/service/PostAdapter;", "afterDiscoveryHandler", "Landroid/os/Handler;", "afterDiscoveryRunnable", "Ljava/lang/Runnable;", "bluetoothRouter", "Ltomaszkopacz/meetbam/router/BluetoothRouter;", "chooseDeviceDialog", "Ltomaszkopacz/meetbam/dialogs/ChooseDeviceDialog;", "commitPhotoDialog", "Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialog;", "discoveredDevices", "Ljava/util/ArrayList;", "Landroid/bluetooth/BluetoothDevice;", "mLoginService", "Ltomaszkopacz/meetbam/service/LoginService;", "pairedUser", "Ltomaszkopacz/meetbam/entity/User;", "photoUri", "Landroid/net/Uri;", "posts", "", "Ltomaszkopacz/meetbam/entity/Post;", "webService", "Ltomaszkopacz/meetbam/interactor/WebService;", "getWebService", "()Ltomaszkopacz/meetbam/interactor/WebService;", "setWebService", "(Ltomaszkopacz/meetbam/interactor/WebService;)V", "commitPost", "", "deviceDiscovered", "device", "deviceSelected", "downloadPosts", "getCustomPhotoUri", "getPhotoDirectory", "Ljava/io/File;", "directory", "", "fileName", "itemCount", "", "logout", "onItemBoundAtPosition", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "position", "onItemClick", "view", "Landroid/view/View;", "pair", "paired", "user", "photoTaken", "requestBT", "scanDevices", "takePhoto", "Companion", "app_debug"})
public final class MainActivityPresenter implements tomaszkopacz.meetbam.presenter.RecyclerViewPresenter, tomaszkopacz.meetbam.dialogs.CommitPhotoDialogPresenter, tomaszkopacz.meetbam.dialogs.ChooseDeviceDialogPresenter, tomaszkopacz.meetbam.presenter.BluetoothPresenter {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public tomaszkopacz.meetbam.interactor.WebService webService;
    private tomaszkopacz.meetbam.service.LoginService mLoginService;
    private tomaszkopacz.meetbam.router.BluetoothRouter bluetoothRouter;
    private tomaszkopacz.meetbam.service.PostAdapter adapter;
    private java.util.List<tomaszkopacz.meetbam.entity.Post> posts;
    private tomaszkopacz.meetbam.dialogs.CommitPhotoDialog commitPhotoDialog;
    private tomaszkopacz.meetbam.dialogs.ChooseDeviceDialog chooseDeviceDialog;
    private java.util.ArrayList<android.bluetooth.BluetoothDevice> discoveredDevices;
    private android.net.Uri photoUri;
    private tomaszkopacz.meetbam.entity.User pairedUser;
    private android.os.Handler afterDiscoveryHandler;
    private java.lang.Runnable afterDiscoveryRunnable;
    private final tomaszkopacz.meetbam.view.MainActivity activity = null;
    private static final java.lang.String BASE_URL = "http://meetbam.cba.pl/";
    private static final java.lang.String PHOTO_DIRECTORY = null;
    public static final tomaszkopacz.meetbam.presenter.MainActivityPresenter.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.interactor.WebService getWebService() {
        return null;
    }
    
    public final void setWebService(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.WebService p0) {
    }
    
    public final void downloadPosts() {
    }
    
    public final void takePhoto() {
    }
    
    public final void photoTaken() {
    }
    
    @java.lang.Override()
    public void pair() {
    }
    
    public final void paired(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.entity.User user) {
    }
    
    @java.lang.Override()
    public void commitPost(@org.jetbrains.annotations.NotNull()
    android.net.Uri photoUri) {
    }
    
    public final void logout() {
    }
    
    @java.lang.Override()
    public void onItemBoundAtPosition(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public void onItemClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public int itemCount() {
        return 0;
    }
    
    private final android.net.Uri getCustomPhotoUri() {
        return null;
    }
    
    private final java.io.File getPhotoDirectory(java.lang.String directory, java.lang.String fileName) {
        return null;
    }
    
    private final void requestBT() {
    }
    
    private final void scanDevices() {
    }
    
    @java.lang.Override()
    public void deviceDiscovered(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device) {
    }
    
    @java.lang.Override()
    public void deviceSelected(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device) {
    }
    
    public MainActivityPresenter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.view.MainActivity activity) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Ltomaszkopacz/meetbam/presenter/MainActivityPresenter$Companion;", "", "()V", "BASE_URL", "", "PHOTO_DIRECTORY", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}