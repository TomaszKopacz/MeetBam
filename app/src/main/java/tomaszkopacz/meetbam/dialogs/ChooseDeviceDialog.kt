package tomaszkopacz.meetbam.dialogs

import android.app.Dialog
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.widget.RadioButton
import android.widget.RadioGroup
import kotterknife.bindView
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.MainPostsFragmentPresenter
import java.util.*

class ChooseDeviceDialog(context: Context, presenter: MainPostsFragmentPresenter) : Dialog(context) {

    private var devices: MutableList<BluetoothDevice> = ArrayList()
    val group: RadioGroup by bindView(R.id.devices_group)

    private val listener = RadioGroup.OnCheckedChangeListener {
        radioGroup, _ ->
            val selectedItem = radioGroup.checkedRadioButtonId
            //presenter.deviceSelected(devices[selectedItem])
    }

    init {
        setContentView(R.layout.dialog_choose_device)

        setTitle("Choose device:")
        group.setOnCheckedChangeListener(listener)

    }

    fun setDevices(devices: MutableList<BluetoothDevice>) {

        this.devices.clear()
        group.removeAllViews()

        this.devices = devices

        for (i in devices.indices) {
            val btn = RadioButton(context)
            btn.text = devices[i].name
            btn.id = i
            group.addView(btn)
        }
    }
}
