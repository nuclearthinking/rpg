package com.nuclearthinking.game.obj.world2;

/**
 * Created by kuksin-mv on 20.01.2016.
 */
public class Cell
{
    public String[] _cell;

    public Cell()
    {
        _cell = new String[6];
        setCellValue(0, "o");
        setCellValue(1, "|");
        setCellValue(2, "۞");
        setCellValue(3, "†");
        setCellValue(4, "≈");

    }

    public Cell(String value, int size)
    {
        _cell = new String[size];

        for (int i = 0; i < _cell.length; i++)
        {
            setCellValue(i, value);
        }
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
