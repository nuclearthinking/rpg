package com.nuclearthinking.game.app.map.interfaces;

import javafx.scene.Group;

/**
 * Created by Izonami on 31.01.2016.
 */
public interface IGameMap
{
    //Размер карты
    public final static int SQUARE_PX_WIDTH = 32;
    public final static int SQUARE_PX_HEIGHT = 32;

    public int getSquareXYCount();

    public Group getMainGroup();
}
