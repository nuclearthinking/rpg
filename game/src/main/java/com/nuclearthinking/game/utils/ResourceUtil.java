package com.nuclearthinking.game.utils;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by onifent
 */

public class ResourceUtil {

    public InputStream getResourceAsStream(String path)
    {
        InputStream is = null;
        try
        {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return is;
    }

    public File getResourceAsFile(String path) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream(path);
        File tempFile = null;
        try {
            tempFile = File.createTempFile("stream2file", ".tmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert tempFile != null;
        tempFile.deleteOnExit();
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(is, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempFile;
    }
}
