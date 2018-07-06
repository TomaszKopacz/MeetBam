package tomaszkopacz.meetbam.service;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import android.view.TextureView;

public class TEST {

    private Context context;
    private TextureView view;

    private CameraManager cameraManager;
    private CameraCharacteristics.Key<Integer> cameraFacing;

    private int cameraID;
    private Size previewSize;

    private TextureView.SurfaceTextureListener listener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {

        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            return false;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {

        }
    };

    public TEST(Context context, TextureView view){
        this.context = context;
        this.view = view;

        cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        cameraFacing = CameraCharacteristics.LENS_FACING;
    }

    private void setUpCamera(){
        try {
            for (String cameraID : cameraManager.getCameraIdList()){
                CameraCharacteristics camChar = cameraManager.getCameraCharacteristics(cameraID);

                StreamConfigurationMap config = camChar.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                previewSize = config.getOutputSizes(SurfaceTexture.class)[0];
            }

        } catch (Exception e){

        }
    }
}
