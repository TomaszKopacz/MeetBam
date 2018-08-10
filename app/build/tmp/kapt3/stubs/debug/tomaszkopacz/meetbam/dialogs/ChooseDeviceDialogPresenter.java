package tomaszkopacz.meetbam.dialogs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Ltomaszkopacz/meetbam/dialogs/ChooseDeviceDialogPresenter;", "", "deviceSelected", "", "device", "Landroid/bluetooth/BluetoothDevice;", "app_debug"})
public abstract interface ChooseDeviceDialogPresenter {
    
    public abstract void deviceSelected(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice device);
}