package tomaszkopacz.meetbam.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import tomaszkopacz.meetbam.R

class ProgressDialog(context: Context?) : Dialog(context) {

    private val layout = layoutInflater.inflate(R.layout.dialog_progress, null)

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(layout)
    }
}