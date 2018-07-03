package tomaszkopacz.meetbam.dialogs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Ltomaszkopacz/meetbam/dialogs/ChooseDeviceDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "presenter", "Ltomaszkopacz/meetbam/presenter/MainPostsFragmentPresenter;", "(Landroid/content/Context;Ltomaszkopacz/meetbam/presenter/MainPostsFragmentPresenter;)V", "devices", "", "Landroid/bluetooth/BluetoothDevice;", "group", "Landroid/widget/RadioGroup;", "getGroup", "()Landroid/widget/RadioGroup;", "group$delegate", "Lkotlin/properties/ReadOnlyProperty;", "listener", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "setDevices", "", "app_debug"})
public final class ChooseDeviceDialog extends android.app.Dialog {
    private java.util.List<android.bluetooth.BluetoothDevice> devices;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadOnlyProperty group$delegate = null;
    private final android.widget.RadioGroup.OnCheckedChangeListener listener = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.RadioGroup getGroup() {
        return null;
    }
    
    public final void setDevices(@org.jetbrains.annotations.NotNull()
    java.util.List<android.bluetooth.BluetoothDevice> devices) {
    }
    
    public ChooseDeviceDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.presenter.MainPostsFragmentPresenter presenter) {
        super(null);
    }
}