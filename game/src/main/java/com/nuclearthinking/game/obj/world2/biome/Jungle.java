package com.nuclearthinking.game.obj.world2.biome;

import com.nuclearthinking.game.obj.world2.Cell;
import com.nuclearthinking.game.obj.world2.Floors;
import com.nuclearthinking.game.obj.world2.Room;

/**
 * Created by Izonami on 22.01.2016.
 */
public class Jungle extends BiomObject
{
    private static Cell cell = new Cell();
    private static Floors floors = new Floors();
    private static Room room;
    private static int _size;
    public static int _floorSize;
    public static int _roomSize;

    public Jungle(int size,int numberOfRoom)
    {
        _size = size;
        createBiome(numberOfRoom);
    }

    private void createBiome(int numberOfRoom)
    {
        String piace = cell.getCellValue(0);
        String tree = cell.getCellValue(3);
        String water = cell.getCellValue(4);


        for (int i = 0; i < numberOfRoom; i++)
        {
            room = new Room(new String[_size][_size]);
            room.setCellIntoRoom(piace, water, tree);
            floors.setFloor(room);
            _roomSize++;
        }
        setBiom("JungleFloor" , floors);
        _floorSize = floors.getFloorSize();
    }

    public void setCellValue(String value)
    {
        room.setCellIntoRoom(value);
    }
}
