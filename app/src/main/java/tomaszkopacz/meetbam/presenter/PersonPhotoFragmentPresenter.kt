package tomaszkopacz.meetbam.presenter

import android.net.Uri
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.UserProfileChangeRequest
import tomaszkopacz.meetbam.dialogs.ProgressDialog
import tomaszkopacz.meetbam.interactor.AuthService
import tomaszkopacz.meetbam.interactor.ImageFilesService
import tomaszkopacz.meetbam.interactor.StorageService
import tomaszkopacz.meetbam.interactor.TaskListener
import tomaszkopacz.meetbam.router.CameraRouter
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.PersonPhotoFragment
import tomaszkopacz.meetbam.view.PersonalisationActivity
import java.io.File
import javax.inject.Inject

class PersonPhotoFragmentPresenter(private val fragment: PersonPhotoFragment) {

    @Inject
    lateinit var imageFilesService: ImageFilesService

    @Inject
    lateinit var storage: StorageService

    @Inject
    lateinit var auth: AuthService

    private var imageFile: File? = null

    private val progressDialog: ProgressDialog = ProgressDialog(fragment.activity!!)

    init {
        (fragment.activity!!.application as MainApp).component!!.inject(this)
    }

    fun skip(){
        (fragment.activity as PersonalisationActivity).goToMainActivity()
    }

    fun takePhoto(camera: CameraRouter){
        progressDialog.show()
        imageFile = imageFilesService.createProfileImageFile()
        camera.takePicture(imageFile!!, fragment.context!!, photoListener)
    }

    private val photoListener = object : CameraRouter.PhotoStateListener {
        override fun onPhotoInProgress() {
        }

        override fun onPhotoTaken() {
            progressDialog.dismiss()
            fragment.setLayout(PersonPhotoFragment.ACCEPT_PHOTO_LAYOUT)
            fragment.showPhoto(imageFile!!)
        }

        override fun onError() {
            progressDialog.dismiss()
        }
    }

    fun dismissPhoto(){
        fragment.setLayout(PersonPhotoFragment.MAKE_PHOTO_LAYOUT)
    }

    fun acceptPhoto(){
        progressDialog.show()

        if (imageFile != null){

            val photoUrl = storage.uploadProfilePhoto(imageFile!!, uploadPhotoListener)
            val firebaseUser = auth.getCurrentUser()
            val profileUpdaterBuilder = UserProfileChangeRequest.Builder()
                    .setPhotoUri(Uri.parse(photoUrl))
                    .build()
            firebaseUser!!.updateProfile(profileUpdaterBuilder)

            progressDialog.dismiss()
            (fragment.activity as PersonalisationActivity).goToMainActivity()

        } else {
            progressDialog.dismiss()
            fragment.setLayout(PersonPhotoFragment.MAKE_PHOTO_LAYOUT)
            Toast.makeText(fragment.context, "ERROR", Toast.LENGTH_LONG).show()
        }
    }

    private val uploadPhotoListener = object : TaskListener {
        override fun onSucceed() {
            Log.d("TOMASZ", "PHOTO SUCCESS")
        }

        override fun onFailed() {
            Log.d("TOMASZ", "PHOTO FAIL")
        }
    }
}