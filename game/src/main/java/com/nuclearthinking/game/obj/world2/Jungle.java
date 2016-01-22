package com.nuclearthinking.game.obj.world2;

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
        createJungle();
    }

    private void createJungle()
    {
        String piace = cell.getCellValue(0);
        String tree = cell.getCellValue(3);
        String water = cell.getCellValue(4);

        Room room, room2;
        room = new Room(new String[_size][_size]);
        room2 = new Room(new String[_size][_size]);

        room.setCellIntoRoom(piace, water, tree);
        room2.setCellIntoRoom(piace, water, tree);

        setBiom("Room1", room);
        setBiom("Room2", room2);
    }
}
