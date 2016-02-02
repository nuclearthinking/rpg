package com.nuclearthinking.game.app.alldrow;

import com.nuclearthinking.game.app.RpgController;
import com.nuclearthinking.game.app.map.MapContainer;
import com.nuclearthinking.game.app.utils.ManagerResources;
import javafx.event.Event;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Created by kuksin-mv on 01.02.2016.
 */
public final class GameWorld extends AbstractIPaint
{
    private static Image bg = ManagerResources.loadImage("img\\bg.png");
    private IPaint next;

    @Override
    public void draw(GraphicsContext context)
    {
        context.drawImage(bg, 0, 10);
    }

    @Override
    public void handle(Event event)
    {
        if(event.getEventType() == MouseEvent.MOUSE_CLICKED)
        {
            System.out.println("Я тут");
            createMap();
        }
    }

    private void createMap()
    {
        MapContainer mapFactory = new MapContainer("img\\map.png");

        next = new RpgController(mapFactory);
    }

    @Override
    public IPaint invoke(){
        return next != null ? next : this;
    }
}
