package com.nuclearthinking.game.obj.world2;

import java.util.ArrayList;

/**
 * Created by kuksin-mv on 20.01.2016.
 */
public class Floors
{
    public ArrayList<Room> _floor = new ArrayList<Room>();

    public void setFloor(Room rooms)
    {
        _floor.add(rooms);
    }

    public int getFloorSize()
    {
        return _floor.size();
    }

    public Room getFloor(int i)
    {
        return _floor.get(i);
    }

}
