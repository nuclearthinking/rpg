package com.nuclearthinking.game.utils;

import java.io.InputStream;

/**
 * Created by onifent
 *
 */

public class ResourceUtil {

    public InputStream getResourceAsStream(String path) {
        InputStream is = null;
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            is = classLoader.getResourceAsStream(path);
            if (is == null) {
                throw new Exception("Невозможно создать поток из указанного файла");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return is;
    }
}
