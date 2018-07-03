package tomaszkopacz.meetbam.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.dialog_commit_photo.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.User

class CommitPhotoDialog(context: Context, internal var presenter: CommitPhotoDialogPresenter)
    : Dialog(context) {

    private var photoUri: Uri? = null

    init {
        setContentView(R.layout.dialog_commit_photo)

        pair_btn.setOnClickListener {presenter.pair()}
        commit_btn.setOnClickListener {presenter.commitPost(photoUri!!)}
    }

    fun loadPhoto(uri: Uri) {
        this.photoUri = uri
        Glide.with(context).load(uri).into(thumbnail_imageview)
    }

    fun pairInProgress(){
        discover_progressbar.visibility = View.VISIBLE
    }

    fun notifyUserPaired(user: User){
        discover_progressbar.visibility = View.GONE
        found_person_textview.text = context
                .getString(R.string.paired_user, user.name, user.surname)

        commit_btn.isClickable = true
        commit_btn.setTextColor(Color.BLACK)
    }
}
