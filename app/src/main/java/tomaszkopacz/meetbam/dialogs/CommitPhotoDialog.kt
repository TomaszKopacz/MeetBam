package tomaszkopacz.meetbam.dialogs

import android.app.Dialog
import android.content.Context
import android.net.Uri
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import butterknife.OnClick
import com.bumptech.glide.Glide
import kotterknife.bindView
import tomaszkopacz.meetbam.R

class CommitPhotoDialog(context: Context, internal var presenter: CommitPhotoDialogPresenter)
    : Dialog(context) {

    val photoImageView: ImageView by bindView(R.id.photo)
    val personTextView: TextView by bindView(R.id.person_found)
    val progressBar: ProgressBar by bindView(R.id.circular_progress_bar)
    val searchBtn: Button by bindView(R.id.pair_btn)
    val acceptBtn: Button by bindView(R.id.accept_btn)

    private var photoUri: Uri? = null

    init {
        setContentView(R.layout.dialog_accept_photo)
    }

    @OnClick(R.id.pair_btn)
    fun onPairBtnClick() {
        presenter.pair()
    }

    fun loadPhoto(uri: Uri) {
        this.photoUri = uri
        Glide.with(context).load(uri).into(photoImageView)
    }

    @OnClick(R.id.accept_btn)
    fun onAcceptBtnClick() {
        presenter.commitPost(photoUri!!)
    }
}
