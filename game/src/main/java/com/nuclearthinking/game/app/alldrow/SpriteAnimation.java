package com.nuclearthinking.game.app.alldrow;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Created by Izonami on 07.02.2016.
 */
public class SpriteAnimation extends Transition
{
    //Спрайт для анимации
    private final ImageView imageView;
    //Кол-во кадров
    private final int count;
    //Кол-во столбцов
    private final int columns;
    //Смещение первого кадра
    private int offsetX, offsetY;
    //Размер кадра
    private final int width, heidth;

    public SpriteAnimation(ImageView imageView, Duration durotation, int count, int columns,
                           int offsetX, int offsetY,
                           int width, int heidth)
    {
        this.imageView = imageView;
        this.count = count;
        this.columns = columns;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.heidth = heidth;
        setCycleDuration(durotation);
        setCycleCount(Animation.INDEFINITE);
        this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, heidth));
    }

    public boolean collide(SpriteAnimation other)
    {
        return false;
    }

    @Override
    protected void interpolate(double frac)
    {
        final int index = Math.min((int) Math.floor(frac * count), count - 1);
        final int x = (index % columns) * width + offsetX;
        final int y = (index / columns) * heidth + offsetY;
        imageView.setViewport(new Rectangle2D(x, y, width, heidth));
    }

    public void setOffsetX(int x)
    {
        this.offsetX = x;
    }
    public void setOffsetY(int y)
    {
        this.offsetY = y;
    }
}
