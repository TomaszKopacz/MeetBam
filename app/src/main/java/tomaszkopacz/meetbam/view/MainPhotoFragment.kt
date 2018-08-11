package tomaszkopacz.meetbam.view

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_main_photo.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.MainPhotoFragmentPresenter
import tomaszkopacz.meetbam.router.CameraRouter
import tomaszkopacz.meetbam.router.CameraRouter.Companion.REQUEST_CAMERA_PERMISSION
import java.io.File

class MainPhotoFragment : Fragment() {

    private lateinit var presenter: MainPhotoFragmentPresenter
    private lateinit var cameraService: CameraRouter

    companion object {
        const val MAKE_PHOTO_LAYOUT = 1
        const val ACCEPT_PHOTO_LAYOUT = 3
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_main_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = MainPhotoFragmentPresenter(this)
        cameraService = CameraRouter(context!!, photo_textureview)

        camera_button.setOnClickListener { presenter.takePhoto(cameraService)}
        back_button.setOnClickListener {presenter.dismissPhoto()}
        pair_button.setOnClickListener { presenter.pair()}
        ok_button.setOnClickListener {presenter.acceptPhoto()}
    }

    override fun onResume() {
        super.onResume()
        cameraService.start()
    }

    override fun onPause() {
        super.onPause()
        cameraService.stop()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                activity!!.finish()
            }
        }
    }

    private fun setLayout(layout: Int){
        when (layout){
            MAKE_PHOTO_LAYOUT -> {
                accept_photo_layout.visibility = View.INVISIBLE
                photo_imageview.visibility = View.INVISIBLE
                camera_button.visibility = View.VISIBLE
            }

            ACCEPT_PHOTO_LAYOUT -> {
                accept_photo_layout.visibility = View.VISIBLE
                photo_imageview.visibility = View.VISIBLE
                camera_button.visibility = View.INVISIBLE
            }
        }
    }

    private fun showProgress(){
        photo_progress_bar.visibility = View.VISIBLE
    }

    private fun stopProgress(){
        photo_progress_bar.visibility = View.GONE
    }

    fun startTakingPhoto(){
        showProgress()
    }

    fun photoTaken(directory: File){
        setLayout(MainPhotoFragment.ACCEPT_PHOTO_LAYOUT)
        stopProgress()
        Glide.with(this).load(directory).into(photo_imageview)
    }

    fun photoDismissed(){
        setLayout(MainPhotoFragment.MAKE_PHOTO_LAYOUT)
    }

    fun startPairing(){
        showProgress()
    }

    fun paired(pairedUser: String){
        users_textview.text = getString(R.string.paired_text, pairedUser)
        stopProgress()
    }

    fun startPostUploading(){
        showProgress()
    }

    fun uploadFailed(){
        stopProgress()
    }

    fun uploadDone(){
        stopProgress()
    }
}