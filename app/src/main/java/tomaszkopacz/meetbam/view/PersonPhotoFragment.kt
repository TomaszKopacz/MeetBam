package tomaszkopacz.meetbam.view


import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_person_photo.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.PersonPhotoFragmentPresenter
import tomaszkopacz.meetbam.router.CameraRouter
import java.io.File

class PersonPhotoFragment : Fragment() {

    private lateinit var presenter: PersonPhotoFragmentPresenter
    private lateinit var camera: CameraRouter

    companion object {
        const val MAKE_PHOTO_LAYOUT = 1
        const val ACCEPT_PHOTO_LAYOUT = 2
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_person_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = PersonPhotoFragmentPresenter(this)
        camera = CameraRouter(context!!, person_textureview)

        skip_person_photo_button.setOnClickListener {presenter.skip()}
        person_photo_button.setOnClickListener {presenter.takePhoto(camera)}
        dismiss_person_photo_button.setOnClickListener {presenter.dismissPhoto()}
        accept_person_photo_button.setOnClickListener {presenter.acceptPhoto()}
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
        if (requestCode == CameraRouter.REQUEST_CAMERA_PERMISSION) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                activity!!.finish()
            }
        }
    }

    fun setLayout(layout: Int){
        when (layout){
            MAKE_PHOTO_LAYOUT -> {
                accept_person_photo_button.visibility = View.INVISIBLE
                dismiss_person_photo_button.visibility = View.INVISIBLE
                person_photo_imageview.visibility = View.INVISIBLE

                person_photo_button.visibility = View.VISIBLE
                skip_person_photo_button.visibility = View.VISIBLE
            }

            ACCEPT_PHOTO_LAYOUT -> {
                accept_person_photo_button.visibility = View.VISIBLE
                dismiss_person_photo_button.visibility = View.VISIBLE
                person_photo_imageview.visibility = View.VISIBLE

                person_photo_button.visibility = View.INVISIBLE
                skip_person_photo_button.visibility = View.INVISIBLE
            }
        }
    }

    fun showPhoto(directory: File){
        setLayout(ACCEPT_PHOTO_LAYOUT)
        Glide.with(this).load(directory).into(person_photo_imageview)
    }
}
