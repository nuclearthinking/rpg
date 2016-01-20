package com.nuclearthinking.game.obj.world2;

/**
 * Created by kuksin-mv on 20.01.2016.
 */
public class Cell
{
    public String[] _cell;

    public Cell()
    {
        _cell = new String[1];
    }

    public String[] getCell()
    {
        return _cell;
    }

    public String getCellValue(int i)
    {
        return _cell[i];
    }

    public void setCell(String[] cell)
    {
        _cell = cell;
    }

    public void setCellValue(int i, String value)
    {
        _cell[i] = value;
    }
}
