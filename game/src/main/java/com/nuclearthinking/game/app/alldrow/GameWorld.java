package com.nuclearthinking.game.app.alldrow;

import com.nuclearthinking.game.app.utils.ManagerResources;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Created by kuksin-mv on 01.02.2016.
 */
public final class GameWorld extends AbstarctIPaint
{
    private static Image bg = ManagerResources.loadImage("img\\background.png");

    @Override
    public void draw(GraphicsContext context)
    {
        context.drawImage(bg, 0, 10);
    }
}
