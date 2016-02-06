package com.nuclearthinking.game.app.map;

import com.nuclearthinking.game.app.utils.ManagerImages;
import com.nuclearthinking.game.app.utils.ManagerResources;
import javafx.scene.image.Image;

/**
 * Created by kuksin-mv on 01.02.2016.
 */
public class MapFactory
{
    private static final ManagerResources MANAGER_RESOURCES = new ManagerResources();
    private static final int PIXEL = 16;

    private static Image[][] images = null;
    private static Image backImg = null;
    private int mapRows = 0;
    private int mapColumns = 0;

    public MapFactory(String imageFile)
    {
        this.backImg = MANAGER_RESOURCES.loadImage(imageFile);
        this.mapColumns = (int) backImg.getWidth() / PIXEL;
        this.mapRows = (int) backImg.getHeight() / PIXEL;
        this.images = ManagerImages.split(backImg, PIXEL, PIXEL);
    }

    public int getMapRows()
    {
        return mapRows;
    }

    public int getMapColumns()
    {
        return mapColumns;
    }

    public Image[][] getImages()
    {
        return images;
    }

}
