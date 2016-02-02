package com.nuclearthinking.game.app.map;

import com.nuclearthinking.game.app.utils.ManagerResources;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

/**
 * Created by kuksin-mv on 01.02.2016.
 */
public class MapFactory
{
    private static final ManagerResources MANAGER_RESOURCES = new ManagerResources();
    private static final int PIXEL = 16;

    private Image[][] images = null;
    private int mapRows = 0;
    private int mapColumns = 0;
    private Image backImg = null;

    public MapFactory(String imageFile)
    {
        this.backImg = MANAGER_RESOURCES.loadImage(imageFile);
        this.mapColumns = (int) backImg.getWidth() / PIXEL;
        this.mapRows = (int) backImg.getHeight() / PIXEL;
        this.images = split(backImg, PIXEL, PIXEL);
    }

    /**
     * Разбивает картинку на кусочки (PIXEL на PIXEL пикселя)
     * т.е на выходе мы имеем массив из квадратиков картинки PIXEL на PIXEL пикселя
     */
    public static Image[][] split(Image source, int width, int height)
    {
        int cols = (int) source.getWidth() / width; //получаем кол-во по ширине
        int rows = (int) source.getHeight() / height; //получаем кол-во по высоте
        Image[][] result = new Image[rows][cols]; //создаём пустой двумерный Image массив
        //Поэтапно двигается по массиву заполняя его кусочками картинки
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                result[i][j] = clip(source, width, height, j * width, i * height); //Заполняем его
            }
        }

        return result;
    }

    public static Image clip(Image source, int width, int height, int x, int y)
    {
        PixelReader reader = source.getPixelReader();
        return new WritableImage(reader, x, y, width, height);
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
