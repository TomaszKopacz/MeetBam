package tomaszkopacz.meetbam.dialogs

import android.bluetooth.BluetoothDevice

interface ChooseDeviceDialogPresenter {
    fun deviceSelected(device: BluetoothDevice)
}
