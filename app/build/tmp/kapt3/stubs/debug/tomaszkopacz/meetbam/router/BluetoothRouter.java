package tomaszkopacz.meetbam.router;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u0010"}, d2 = {"Ltomaszkopacz/meetbam/router/BluetoothRouter;", "", "presenter", "Ltomaszkopacz/meetbam/presenter/BluetoothPresenter;", "(Ltomaszkopacz/meetbam/presenter/BluetoothPresenter;)V", "btIntentFilter", "Landroid/content/IntentFilter;", "btReceiver", "tomaszkopacz/meetbam/router/BluetoothRouter$btReceiver$1", "Ltomaszkopacz/meetbam/router/BluetoothRouter$btReceiver$1;", "startReceiving", "", "context", "Landroid/content/Context;", "stopReceiving", "Companion", "app_debug"})
public final class BluetoothRouter {
    private final android.content.IntentFilter btIntentFilter = null;
    private final android.content.BroadcastReceiver btReceiver = null;
    private static android.bluetooth.BluetoothAdapter bluetoothAdapter;
    public static final tomaszkopacz.meetbam.router.BluetoothRouter.Companion Companion = null;
    
    public final void startReceiving(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void stopReceiving(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public BluetoothRouter(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.BluetoothPresenter presenter) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Ltomaszkopacz/meetbam/router/BluetoothRouter$Companion;", "", "()V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "kotlin.jvm.PlatformType", "closeBluetooth", "", "getRemoteAddress", "", "isBluetoothOn", "", "openBluetooth", "startDiscovery", "stopDiscovery", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getRemoteAddress() {
            return null;
        }
        
        public final boolean isBluetoothOn() {
            return false;
        }
        
        public final void openBluetooth() {
        }
        
        public final void closeBluetooth() {
        }
        
        public final void startDiscovery() {
        }
        
        public final void stopDiscovery() {
        }
        
        private Companion() {
            super();
        }
    }
}