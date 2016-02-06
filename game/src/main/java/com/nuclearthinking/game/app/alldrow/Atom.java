package com.nuclearthinking.game.app.alldrow;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

/**
 * Created by kuksin-mv on 04.02.2016.
 */
public class Atom extends Sprite
{
    public Atom(String spriteFile, int direction)
    {
        super(spriteFile, direction);
        setPosition(new Point(10, 10));
    }

    @Override
    public void update()
    {
        stepCounter++;
        stepCounter = stepCounter % 100;

        vY++;
        vX++;
    }

    @Override
    public boolean collide(Sprite other)
    {
        return false;
    }

    public boolean isAtom()
    {
        return true;
    }

    @Override
    public void draw(GraphicsContext context, int offsetX, int offsetY)
    {
        int nx = vX + offsetX - getSpriteOffsetX();
        int ny = vY + offsetY - getSpriteOffsetY();

        context.setFill(Color.rgb(0, 0, 0, 0.5));
        context.fillOval(nx + 15, ny + sfactory.getSpriteHeight() - sfactory.getSpriteHeight() / 5,
                PIXEL * 5 / 4, PIXEL * 2 / 3);

        context.drawImage(getSpriteImage(), nx, ny);
    }

}
