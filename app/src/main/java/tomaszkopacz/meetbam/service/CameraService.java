package tomaszkopacz.meetbam.service;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.io.IOException;

/**
 * Created by tomas on 14.03.2018.
 */

public class CameraService {

    /**
     * Returns new file for a given directory. A file is used to store a photo.
     * @return new file or null if error occurs
     */
    public static File getFileForDirectory(String directory, String fileName){

        File pathFile;
        File file;

        if (directory == null || fileName == null || fileName.isEmpty() ) {
            return null;

        } else {

            // path files
            pathFile = new File(directory);
            pathFile.mkdirs();

            // file directory
            String dir = directory + fileName;

            // file
            file = new File(dir);

            try {
                // create file
                file.createNewFile();

            } catch (IOException e) {
                return null;
            }
        }

        return file;
    }

    /**
     * Returns camera intent.
     * @param file file to store a photo
     * @return intent
     */
    public static Intent getCameraIntent(File file){

        // create intent
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // set external storage uri
        Uri uri;
        if ( (uri = Uri.fromFile(file)) != null)
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

        return cameraIntent;
    }
}
