package tomaszkopacz.meetbam.service;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

import org.junit.Test;

import java.io.File;

import static junit.framework.Assert.assertTrue;

/**
 * Created by tomas on 14.03.2018.
 */

public class CameraServiceTest {

    @Test
    /**
     * Test getFileForDirectory method. Should return null if directory argument is null.
     */
    public void testGetFileForDirectoryWhenDirectoryIsNull(){

        String directory = null;
        String fileName = "file_name";

        File file = CameraService.INSTANCE.getFileForDirectory(directory, fileName);
        assertTrue(file == null);
    }

    @Test
    /**
     * Test getFileForDirectory method. Should return null if file name argument is null.
     */
    public void testGetFileForDirectoryWhenFileNameIsNull(){

        String directory = "directory/meetbam/";
        String fileName = null;

        File file = CameraService.INSTANCE.getFileForDirectory(directory, fileName);
        assertTrue(file == null);
    }

    @Test
    /**
     * Test getFileForDirectory method. Should return null if file name is empty.
     */
    public void testGetFileForDirectoryWhenFileNameIsEmpty(){

        String directory = "directory/meetbam/";
        String fileName = "";

        File file = CameraService.INSTANCE.getFileForDirectory(directory, fileName);
        assertTrue(file == null);
    }

    @Test
    /**
     * Test getFileForDirectory method. Should return non null file.
     */
    public void testGetFileForDirectory(){
        String directory = "directory/meetbam/";
        String fileName = "photo_name";

        File file = CameraService.INSTANCE.getFileForDirectory(directory, fileName);
        assertTrue(file != null);
    }

    @Test
    /**
     * Test getCameraIntent() method. Should return non null intent.
     */
    public void testGetCameraIntent(){
        String directory = "directory/meetbam/";
        String fileName = "photo_name";
        File file = CameraService.INSTANCE.getFileForDirectory(directory, fileName);

        Intent cameraIntent = CameraService.INSTANCE.getCameraIntent(file);
        assertTrue(cameraIntent != null);
    }
}
