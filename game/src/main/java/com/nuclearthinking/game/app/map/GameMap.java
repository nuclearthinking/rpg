package com.nuclearthinking.game.app.map;

import com.nuclearthinking.game.app.map.interfaces.IGameMap;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Izonami on 31.01.2016.
 */
public class GameMap implements IGameMap
{
    //Диагональ
    private final static int SQUARE_XY_COUNT = (int) (Math.sqrt(SQUARE_PX_HEIGHT) + Math.sqrt(SQUARE_PX_WIDTH));
    private final static Image BACKGROUND_IMAGE = new Image(GameMap.class.getResource("/img/background.png").toString());

    //Это группа нод, которые можно накладывать друг на друга и создавать что то вроде слоёв как в фотошопе
    private Group mainGroup;

    public GameMap()
    {
        initGameMap();
    }

    private void initGameMap()
    {
        ImageView backgroundView = new ImageView(BACKGROUND_IMAGE);
        mainGroup = new Group(backgroundView);
    }

    @Override
    public int getSquareXYCount()
    {
        return SQUARE_XY_COUNT;
    }

    @Override
    public Group getMainGroup()
    {
        return mainGroup;
    }
}
