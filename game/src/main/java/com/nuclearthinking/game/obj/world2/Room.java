package com.nuclearthinking.game.obj.world2;

import com.nuclearthinking.game.utils.WorldGenerateUtil;

/**
 * Created by kuksin-mv on 20.01.2016.
 */
public class Room
{
    private static WorldGenerateUtil wgu = new WorldGenerateUtil();
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

    public void setRoom(Cell cell, Cell cell2)
    {
        for (int i = 0; i < this._room.length; i++)
        {
            for (int j = 0; j < this._room[i].length; j++)
            {
                int tmp = wgu.getRnd(0, 10);
                if (tmp <= 5)
                {
                    this.setRoomValue(i, j, cell.getCellValue(0));
                }
                else if (tmp >= 6)
                {
                    this.setRoomValue(i, j, cell2.getCellValue(0));
                }
            }
        }
    }
}
