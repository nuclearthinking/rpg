package com.nuclearthinking.game.app;

import com.nuclearthinking.game.app.alldrow.AbstractIPaint;
import com.nuclearthinking.game.app.map.MapContainer;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by kuksin-mv on 01.02.2016.
 */
public class RpgController extends AbstractIPaint
{
    private MapContainer map;

    public RpgController(MapContainer mc)
    {
        this.map = mc;
    }

    @Override
    public void draw(GraphicsContext context)
    {
        map.draw(context);
    }
}
