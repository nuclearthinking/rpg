package com.nuclearthinking.game.obj.world2;

/**
 * Created by kuksin-mv on 20.01.2016.
 */
public class Room
{
    public String[][] _room;

    public String[][] getRoom()
    {
        return _room;
    }

    public String getRoomValue(int x, int y)
    {
        return _room[x][y];
    }

    public String getRoomValue(int x)
    {
        return _room[x][0];
    }

    public void setRoom(String[][] room)
    {
        _room = room;
    }

    public void setRoomValue(int x, int y, String value)
    {
        _room[x][y] = value;
    }
}
