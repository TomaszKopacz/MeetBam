package tomaszkopacz.meetbam.service;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyCameraService {

    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open();

        } catch (Exception e){

        }

        return c;
    }

    class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

        private SurfaceHolder holder;
        private Camera camera;

        public CameraPreview(Context context, Camera camera) {
            super(context);
            this.camera = camera;

            holder = getHolder();
            holder.addCallback(this);
            holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            try {
                camera.setPreviewDisplay(holder);
                camera.startPreview();

            } catch (Exception e){

            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    }
}
