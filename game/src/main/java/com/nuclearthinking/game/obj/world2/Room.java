package com.nuclearthinking.game.obj.world2;

import com.nuclearthinking.game.utils.WorldGenerateUtil;

/**
 * Created by kuksin-mv on 20.01.2016.
 */
public class Room
{
    private static WorldGenerateUtil wgu = new WorldGenerateUtil();
    private String[][] _room;

    public Room(String[][] value)
    {
        setRoom(value);
    }

    public String[][] getRoom()
    {
        return _room;
    }

    public int getRoomSize()
    {
        return _room.length;
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

    public void setCellIntoRoom(String... cell)
    {
        for (int i = 0; i < this._room.length; i++)
        {
            for (int j = 0; j < this._room[i].length; j++)
            {
                int tmp = wgu.getRnd(0, 10);
                if (tmp <= 5)
                {
                    this.setRoomValue(i, j, cell[0]);
                }
                else if (tmp >= 6 && tmp <= 9)
                {
                    this.setRoomValue(i, j, cell[1]);
                }
                else
                {
                    this.setRoomValue(i, j, cell[2]);
                }
            }
        }
    }

    public void setCellIntoRoom(String value)
    {
        for (int i = 0; i < this._room.length; i++)
        {
            for (int j = 0; j < this._room[i].length; j++)
            {
                int tmp = wgu.getRnd(0, _room.length);
                int x = tmp;
                int y = tmp;
                if (tmp <= 5)
                {
                    this.setRoomValue(x, y, value);
                    return;
                }
                else if (tmp >= 6 && tmp <= 9)
                {
                    this.setRoomValue(x, y, value);
                    return;
                }
                else
                {
                    this.setRoomValue(x, y, value);
                    return;
                }
            }
        }
    }
}
