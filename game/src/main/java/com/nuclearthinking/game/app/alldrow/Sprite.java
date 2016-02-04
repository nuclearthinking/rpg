package com.nuclearthinking.game.app.alldrow;

import javafx.animation.Animation;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuksin-mv on 04.02.2016.
 */
public abstract class Sprite
{
    public List<Animation> animations = new ArrayList<Animation>();
    public Node node;
    public double vX = 0;
    public double vY = 0;

    public abstract void update();

    public boolean collide(Sprite other)
    {
        return false;
    }

    public boolean isAtom()
    {
        return false;
    }
}
