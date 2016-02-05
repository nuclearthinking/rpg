package com.nuclearthinking.game.app.alldrow;

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
        setTranslateX(getTranslateX() + vX);
        setTranslateY(getTranslateY() + vY);
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

}
