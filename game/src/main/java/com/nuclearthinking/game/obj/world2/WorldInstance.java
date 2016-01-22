package com.nuclearthinking.game.obj.world2;

import java.util.Map;

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

        Jungle jungle = new Jungle(_worldSize);
        biomOut(jungle);
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

    private void biomOut(BiomObject biom)
    {
        for(Map.Entry<String, Room> map : biom.getBiom().entrySet())
        {
            Room value = map.getValue();
            roomOut(value);
        }
    }
}
