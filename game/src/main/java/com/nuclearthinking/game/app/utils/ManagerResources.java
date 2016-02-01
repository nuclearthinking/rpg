package com.nuclearthinking.game.app.utils;

import com.nuclearthinking.game.utils.ResourceUtil;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kuksin-mv on 01.02.2016.
 */
public class ManagerResources
{
    private static ResourceUtil resourceUtil = new ResourceUtil();

    public static Cursor loadCursor()
    {
        return new ImageCursor(loadImage("img\\cursor.png"));
    }

    public static Image loadImage(String fileName)
    {
        Image result = null;

            try(InputStream is = resourceUtil.getResourceAsStream(fileName))
            {
                result = new Image(is);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        return result;
    }
}
