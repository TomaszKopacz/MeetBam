package tomaszkopacz.meetbam.dialogs;

import android.app.Dialog;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.presenters.MainActivityPresenter;

/**
 * Created by tomas on 27.05.2018.
 */

public class ChooseDeviceDialog extends Dialog {

    private Context context;
    private MainActivityPresenter presenter;

    private List<BluetoothDevice> devices = new ArrayList<>();

    @BindView(R.id.devices_group)
    RadioGroup group;

    public ChooseDeviceDialog(Context context, MainActivityPresenter presenter) {
        super(context);

        this.context = context;
        this.presenter = presenter;
        setContentView(R.layout.dialog_choose_device);
        ButterKnife.bind(this);

        setTitle("Choose device:");
        group.setOnCheckedChangeListener(listener);

    }

    public void setDevices(List<BluetoothDevice> devices){

        this.devices.clear();
        group.removeAllViews();

        this.devices = devices;

        for (int i = 0; i < devices.size(); i++){
            RadioButton btn = new RadioButton(context);
            btn.setText(devices.get(i).getName());
            btn.setId(i);
            group.addView(btn);
        }
    }

    private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {

            int selectedItem = radioGroup.getCheckedRadioButtonId();
            presenter.deviceSelected(devices.get(selectedItem).getAddress());
        }
    };
}
