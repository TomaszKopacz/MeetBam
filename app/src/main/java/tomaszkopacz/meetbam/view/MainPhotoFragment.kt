package tomaszkopacz.meetbam.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_main_photo.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.MainPhotoFragmentPresenter
import tomaszkopacz.meetbam.service.CameraService
import java.io.File


class MainPhotoFragment : Fragment() {

    private lateinit var presenter: MainPhotoFragmentPresenter
    private lateinit var cameraService: CameraService

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
        cameraService = CameraService(context!!, photo_textureview)
        camera_button.setOnClickListener {presenter.takePhoto(cameraService)}
    }

    override fun onResume() {
        super.onResume()
        cameraService.start()
    }

    override fun onPause() {
        super.onPause()
        cameraService.stop()
    }

    fun setLayout(layout: Int){
        when (layout){
            MAKE_PHOTO_LAYOUT -> {
                paired_user_textview.visibility = View.INVISIBLE
                description_inputlayout.visibility = View.INVISIBLE
                decription_edittext.visibility = View.INVISIBLE
                photo_imageview.visibility = View.INVISIBLE
                dismiss_button.visibility = View.INVISIBLE
                pair_button.visibility = View.INVISIBLE
                accept_button.visibility = View.INVISIBLE

                camera_button.visibility = View.VISIBLE
            }

            ACCEPT_PHOTO_LAYOUT -> {
                paired_user_textview.visibility = View.VISIBLE
                description_inputlayout.visibility = View.VISIBLE
                decription_edittext.visibility = View.VISIBLE
                photo_imageview.visibility = View.VISIBLE
                dismiss_button.visibility = View.VISIBLE
                pair_button.visibility = View.VISIBLE
                accept_button.visibility = View.VISIBLE

                camera_button.visibility = View.INVISIBLE
            }
        }
    }

    fun loadPhoto(directory: File){
        Glide.with(this).load(directory).into(photo_imageview)
    }
}
