package com.nuclearthinking.game.app.alldrow;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;

/**
 * Created by kuksin-mv on 04.02.2016.
 */
public class Atom extends Sprite
{
    public Atom(double radius)
    {
        Circle circle = new Circle();
        circle.setCenterX(radius);
        circle.setCenterY(radius);
        circle.setRadius(radius);
        circle.setCache(true);

        node = circle;
    }

    public Circle getAsCircle()
    {
        return (Circle) node;
    }

    public void draw(GraphicsContext context)
    {
        //context.fillOval(10, 60, 30, 30);
    }

    @Override
    public void update()
    {

        node.setTranslateX(node.getTranslateX() + vX);
        node.setTranslateY(node.getTranslateY() + vY);
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
