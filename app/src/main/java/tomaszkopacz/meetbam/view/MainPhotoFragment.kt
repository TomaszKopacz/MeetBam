package tomaszkopacz.meetbam.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main_photo.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.MainActivityPresenter
import tomaszkopacz.meetbam.service.CameraService


class MainPhotoFragment : Fragment() {

    private lateinit var presenter: MainActivityPresenter
    private lateinit var cameraService: CameraService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_main_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = MainActivityPresenter(activity as MainActivity)
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
}
