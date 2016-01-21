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

        Cell cell = new Cell();
        Cell cell2 = new Cell();
        Room room = new Room();
        Room room2 = new Room();
        cell.setCellValue(0, "o");
        cell2.setCellValue(0, "|");
        room.setRoom(new String[WORLD_SIZE][WORLD_SIZE]);
        room2.setRoom(new String[WORLD_SIZE][WORLD_SIZE]);
        worldInstance.setRoom(room, cell, cell2);
        worldInstance.setRoom(room2, cell, cell2);
        worldInstance.roomOut(room);
        worldInstance.roomOut(room2);
    }

    public WorldInstance(int _worldSize)
    {
        setSize(_worldSize);
    }

    private void setSize(int _worldSize)
    {
        WORLD_SIZE = _worldSize;
    }

    private int getRnd(int min, int max)
    {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

    private void setRoom(Room room, Cell cell, Cell cell2)
    {
        for (int i = 0; i < room._room.length; i++)
        {
            for (int j = 0; j < room._room[i].length; j++)
            {
                int tmp = getRnd(0, 10);
                if (tmp <= 5)
                {
                    room.setRoomValue(i, j, cell.getCellValue(0));
                }
                else if (tmp >= 6)
                {
                    room.setRoomValue(i, j, cell2.getCellValue(0));
                }

            }
        }
    }

    private void roomOut(Room room)
    {
        for(int i = 0; i < room._room.length; i++)
        {
            for(int j = 0; j < room._room[i].length; j++)
            {
                System.out.print(room._room[i][j] + " ");
            }
            System.out.println();
        }
    }
}
