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
    private lateinit var camera: CameraRouter

    companion object {
        const val MAKE_PHOTO_LAYOUT = 1
        const val ACCEPT_PHOTO_LAYOUT = 2
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_main_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = MainPhotoFragmentPresenter(this)
        camera = CameraRouter(context!!, camera_textureview)

        photo_button.setOnClickListener { presenter.takePhoto(camera)}
        dismiss_photo_button.setOnClickListener {presenter.dismissPhoto()}
        pairing_button.setOnClickListener {presenter.pair()}
        accept_photo_button.setOnClickListener {presenter.acceptPhoto()}
    }

    override fun onResume() {
        super.onResume()
        camera.start()
    }

    override fun onPause() {
        super.onPause()
        camera.stop()
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
                accept_photo_button.visibility = View.INVISIBLE
                dismiss_photo_button.visibility = View.INVISIBLE
                pairing_button.visibility = View.INVISIBLE
                photo_imageview.visibility = View.INVISIBLE

                photo_button.visibility = View.VISIBLE
            }

            ACCEPT_PHOTO_LAYOUT -> {
                accept_photo_button.visibility = View.VISIBLE
                dismiss_photo_button.visibility = View.VISIBLE
                pairing_button.visibility = View.VISIBLE
                photo_imageview.visibility = View.VISIBLE

                photo_button.visibility = View.INVISIBLE
            }
        }
    }

    fun clearLayout(){
        setLayout(MainPhotoFragment.MAKE_PHOTO_LAYOUT)
        paired_textview.text = getString(R.string.not_paired_text)
    }

    fun showPhoto(directory: File){
        setLayout(MainPhotoFragment.ACCEPT_PHOTO_LAYOUT)
        Glide.with(this).load(directory).into(photo_imageview)
    }

    fun notifyUsersPaired(loggedUser: String, pairedUser: String){
        paired_textview.text = getString(R.string.paired_text, loggedUser, pairedUser)
    }
}