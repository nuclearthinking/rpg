package com.nuclearthinking.game.obj.world2.biome;

import com.nuclearthinking.game.obj.world2.Cell;
import com.nuclearthinking.game.obj.world2.Room;

/**
 * Created by Izonami on 22.01.2016.
 */
public class Jungle extends BiomObject
{
    private static Cell cell = new Cell();
    private static int _size;

    public Jungle(int size)
    {
        _size = size;
        createBiome();
    }

    private void createBiome()
    {
        String piace = cell.getCellValue(0);
        String tree = cell.getCellValue(3);
        String water = cell.getCellValue(4);

        Room room;
        room = new Room(new String[_size][_size]);

        room.setCellIntoRoom(piace, water, tree);

        setBiom("Jungle", room);
    }
}
