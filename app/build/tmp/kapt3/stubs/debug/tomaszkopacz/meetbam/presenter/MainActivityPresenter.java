package tomaszkopacz.meetbam.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \'2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\'B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0006\u0010 \u001a\u00020\u001bJ\b\u0010!\u001a\u00020\u001bH\u0016J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0017J\u0006\u0010$\u001a\u00020\u001bJ\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Ltomaszkopacz/meetbam/presenter/MainActivityPresenter;", "Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialogPresenter;", "Ltomaszkopacz/meetbam/dialogs/ChooseDeviceDialogPresenter;", "Ltomaszkopacz/meetbam/presenter/BluetoothPresenter;", "activity", "Ltomaszkopacz/meetbam/view/MainActivity;", "(Ltomaszkopacz/meetbam/view/MainActivity;)V", "afterDiscoveryHandler", "Landroid/os/Handler;", "afterDiscoveryRunnable", "Ljava/lang/Runnable;", "bluetoothRouter", "Ltomaszkopacz/meetbam/router/BluetoothRouter;", "chooseDeviceDialog", "Ltomaszkopacz/meetbam/dialogs/ChooseDeviceDialog;", "commitPhotoDialog", "Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialog;", "discoveredDevices", "Ljava/util/ArrayList;", "Landroid/bluetooth/BluetoothDevice;", "mLoginService", "Ltomaszkopacz/meetbam/service/LoginService;", "pairedUser", "Ltomaszkopacz/meetbam/entity/User;", "photoUri", "Landroid/net/Uri;", "commitPost", "", "deviceDiscovered", "device", "deviceSelected", "getCustomPhotoUri", "logout", "pair", "paired", "user", "photoTaken", "requestBT", "scanDevices", "Companion", "app_debug"})
public final class MainActivityPresenter implements tomaszkopacz.meetbam.dialogs.CommitPhotoDialogPresenter, tomaszkopacz.meetbam.dialogs.ChooseDeviceDialogPresenter, tomaszkopacz.meetbam.presenter.BluetoothPresenter {
    private tomaszkopacz.meetbam.service.LoginService mLoginService;
    private tomaszkopacz.meetbam.router.BluetoothRouter bluetoothRouter;
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
    
    public final void photoTaken() {
    }
    
    public final void logout() {
    }
    
    private final android.net.Uri getCustomPhotoUri() {
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