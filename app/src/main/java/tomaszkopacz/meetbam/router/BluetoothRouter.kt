package tomaszkopacz.meetbam.router

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import tomaszkopacz.meetbam.presenter.BluetoothPresenter


class BluetoothRouter (presenter: BluetoothPresenter) {

    private val btIntentFilter = IntentFilter()
    private val btReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action

            when (action) {
                BluetoothDevice.ACTION_FOUND -> {
                    val device = intent
                            .getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE)
                    presenter!!.deviceDiscovered(device)
                }
            }
        }
    }

    init {
        btIntentFilter.addAction(BluetoothDevice.ACTION_FOUND)
    }

    companion object {
        private var bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

        fun getRemoteAddress(): String{
            return bluetoothAdapter.address
        }

        fun isBluetoothOn(): Boolean {
            return bluetoothAdapter.isEnabled
        }

        fun openBluetooth(){
            bluetoothAdapter.enable()
        }

        fun closeBluetooth(){
            bluetoothAdapter.disable()
        }

        fun startDiscovery(){
            bluetoothAdapter.startDiscovery()
        }

        fun  stopDiscovery(){
            bluetoothAdapter.startDiscovery()
        }
    }

    fun startReceiving(context: Context){
        context.registerReceiver(btReceiver, btIntentFilter)
    }

    fun stopReceiving(context: Context){
        context.unregisterReceiver(btReceiver)
    }
}