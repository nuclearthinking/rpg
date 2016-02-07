package com.nuclearthinking.game.app.map;

import com.nuclearthinking.game.app.utils.ManagerResources;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by kuksin-mv on 01.02.2016.
 */
public class MapContainer extends Pane
{
    private final Image MAP = ManagerResources.loadImage("img\\map.png");
    private final ImageView imageView = new ImageView(MAP);
    private static final int SPRITE_WIDTH = 1536;
    private static final int SPRITE_HEIGHT = 1536;
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 0;

    public MapContainer()
    {
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, SPRITE_WIDTH, SPRITE_HEIGHT));
        getChildren().add(imageView);
    }




}
