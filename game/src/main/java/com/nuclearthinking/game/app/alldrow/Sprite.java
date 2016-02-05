package com.nuclearthinking.game.app.alldrow;

import com.nuclearthinking.game.app.map.MapContainer;
import javafx.animation.Animation;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuksin-mv on 04.02.2016.
 */
public abstract class Sprite
{
    public List<Animation> animations = new ArrayList<Animation>();
    public SpriteFactory sfactory;
    public int vX, vY;

    private static final int PIXEL = 16;
    private MapContainer map;
    private int direction;

    private int stepCounter = 0;
    private int px, py;

    public Sprite(String spriteFile, int direction)
    {
        this.sfactory = new SpriteFactory(spriteFile);
        this.direction = direction;
    }

    public abstract void update();

    public boolean collide(Sprite other)
    {
        return false;
    }

    public boolean isAtom()
    {
        return false;
    }

    public void setMapContainer(MapContainer map)
    {
        this.map = map;
    }

    public void setPosition(Point point)
    {
        this.px = point.x;
        this.py = point.y;
        this.vX = this.px * PIXEL;
        this.vY = this.py * PIXEL;
    }

    public void draw(GraphicsContext context, int offsetX, int offsetY)
    {
        context.restore();
        stepCounter++;
        stepCounter = stepCounter % 100;

        int nx = vX + offsetX - getSpriteOffsetX();
        int ny = vY + offsetY - getSpriteOffsetY();

        context.setFill(Color.rgb(0, 0, 0, 0.5));
        context.fillOval(nx + 15, ny + sfactory.getSpriteHeight() - sfactory.getSpriteHeight() / 5,
                PIXEL * 5 / 4, PIXEL * 2 / 3);

        context.drawImage(getSpriteImage(), nx, ny);
        /*ImageUtils.drawStyleString(context, name, nx + getSpriteOffsetX() - 25, ny + getSpriteOffsetY()
                + 36);
        ImageUtils.drawStyleString(context, group, nx + getSpriteOffsetX() - 25, ny
                + getSpriteOffsetY() + 50);*/
    }

    public Image getSpriteImage()
    {
        Image result = sfactory.getMove(direction)[stepCounter / 25];

        return result;
    }

    public int getTranslateX()
    {
        return vX;
    }

    public void setTranslateX(int vx)
    {
        this.vX = vx;
    }

    public int getTranslateY()
    {
        return vY;
    }

    public void setTranslateY(int vy)
    {
        this.vY = vy;
    }

    public int getSpriteOffsetX()
    {
        return sfactory.getSpriteWidth() - PIXEL;
    }

    public int getSpriteOffsetY()
    {
        return sfactory.getSpriteHeight() - PIXEL;
    }
}
