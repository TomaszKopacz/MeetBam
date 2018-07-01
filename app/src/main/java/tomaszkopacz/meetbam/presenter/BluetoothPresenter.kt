package tomaszkopacz.meetbam.presenter

import android.bluetooth.BluetoothDevice

interface BluetoothPresenter {
    fun deviceDiscovered(device: BluetoothDevice)
}
