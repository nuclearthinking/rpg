package com.nuclearthinking.game.app.map;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by kuksin-mv on 01.02.2016.
 */
public class MapContainer
{
    private static final byte PIXEL = 16;

    private MapFactory factory;

    public MapContainer(String image)
    {
        this.factory = new MapFactory(image);
    }

    //Рисует картинку
    public void draw(GraphicsContext context)
    {
        //Смещение картинки относительно оболочки из-за MenuBar пришлось двинуть на 10 по Y
        int offsetX = 0, offsetY = 10;

        for(int i = 0; i < getRows(); i++)
        {
            for(int j = 0; j < getColumns(); j++)
            {
                //Рисует картинку по кусочкам слева на право, сверху вниз
                context.drawImage(factory.getImages()[j][i], boxToPixels(i) + offsetX, boxToPixels(j) + offsetY);
            }
        }
    }

    //Это для обратной сборки картинки, что бы квадраты не расползлись друг от друга и не влепились в один
    public static int boxToPixels(int box)
    {
        return box * PIXEL;
    }

    //Кол-во строк в картинке
    public int getRows()
    {
        return factory.getMapRows();
    }

    //Кол-во столбцов в картинке
    public int getColumns()
    {
        return factory.getMapColumns();
    }

}
