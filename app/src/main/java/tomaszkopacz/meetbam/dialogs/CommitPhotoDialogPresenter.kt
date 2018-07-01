package tomaszkopacz.meetbam.dialogs

import android.net.Uri

interface CommitPhotoDialogPresenter {

    fun pair()
    fun commitPost(photoUri: Uri)
}
