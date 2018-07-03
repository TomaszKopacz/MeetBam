package tomaszkopacz.meetbam.view


import android.hardware.Camera
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main_photo.*

import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.service.CameraService


class MainPhotoFragment : Fragment() {

    private lateinit var camera: Camera
    private lateinit var cameraPreview: CameraService.CameraPreview

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_main_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        camera = CameraService.getCameraInstance()
        cameraPreview = CameraService.CameraPreview(this.activity!!, camera)
        camera_preview.addView(cameraPreview)
    }

}
