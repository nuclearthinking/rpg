package com.nuclearthinking.game.obj.world2;

import com.nuclearthinking.game.obj.world2.biome.BiomObject;
import com.nuclearthinking.game.obj.world2.biome.Jungle;

import java.util.Map;

/**
 * Created by kuksin-mv on 20.01.2016.
 */
public class WorldInstance
{
    public static Jungle jungle;

    public static void main(String[] args)
    {
        WorldInstance worldInstance = new WorldInstance(10);
        worldInstance.biomOut(jungle);
    }

    public WorldInstance(int biomSize)
    {
        jungle = new Jungle(biomSize);
    }

    private void roomOut(Room room)
    {
        for(int i = 0; i < room.getRoomSize(); i++)
        {
            for(int j = 0; j < room.getRoomSize(); j++)
            {
                System.out.print(room.getRoom()[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void biomOut(BiomObject biom)
    {
        for(Map.Entry<String, Room> map : biom.getBiom().entrySet())
        {
            Room value = map.getValue();
            roomOut(value);
        }
    }
}
