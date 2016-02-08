package com.nuclearthinking.game.app.utils;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by kuksin-mv on 03.02.2016.
 */
public class ManagerImages
{
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

    public static void drawStyleString(Text text, String msg, double x, double y)
    {
        if(msg == null || msg.length() == 0)
            return;

        text.setStroke(Color.BLACK);
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        text.setText(msg);
        text.setX(x);
        text.setY(y);
    }
}
