package com.nuclearthinking.game.obj.world2;

/**
 * Created by kuksin-mv on 20.01.2016.
 */
public class WorldInstance
{
    private static int WORLD_SIZE;

    public static void main(String[] args)
    {
        WorldInstance worldInstance = new WorldInstance(10);
    }

    public WorldInstance(int _worldSize)
    {
        setSize(_worldSize);
        Cell cell = new Cell();

        String piace = cell.getCellValue(0);
        String wall = cell.getCellValue(1);
        String bonus = cell.getCellValue(2);

        Room room, room2;
        room = new Room(new String[WORLD_SIZE][WORLD_SIZE]);
        room2 = new Room(new String[WORLD_SIZE][WORLD_SIZE]);

        room.setCellIntoRoom(piace, wall, bonus);
        room2.setCellIntoRoom(piace, wall, bonus);

        this.roomOut(room);
        this.roomOut(room2);
    }

    private void setSize(int _worldSize)
    {
        WORLD_SIZE = _worldSize;
    }

    private void roomOut(Room room)
    {
        for(int i = 0; i < room._room.length; i++)
        {
            for(int j = 0; j < room._room[i].length; j++)
            {
                System.out.print(room._room[i][j] + " ");
                System.out.print(room._room[i][j] + " ");
                System.out.print(room._room[j][i] + " ");
                System.out.print(room._room[i][j] + " ");
            }
            System.out.println();
        }
    }
}
