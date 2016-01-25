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
        WorldInstance worldInstance = new WorldInstance(10, 5);
        worldInstance.biomOut(jungle);
    }

    public WorldInstance(int biomSize, int numberOfRooms)
    {
        jungle = new Jungle(biomSize, numberOfRooms);
    }

    private void floorsOut(Floors floors)
    {
        if (floors == null || floors.getFloorSize() == 0)
        {
            return;
        }

        for(int i = 0; i < floors.getFloorSize(); i++)
        {
            roomOut(floors.getFloor(i));
            System.out.println();
        }
    }

    private void roomOut(Room room)
    {
        if (room == null || room.getRoomSize() == 0)
        {
            return;
        }

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
        if(biom == null || biom.getBiomSize() == 0)
        {
            return;
        }
        for(Map.Entry<String, Floors> map : biom.getBiom().entrySet())
        {
            Floors value = map.getValue();
            floorsOut(value);
        }
    }

    public void biomOut(BiomObject biomObject, int floor)
    {
        if(biomObject == null || biomObject.getBiomSize() == 0)
        {
            return;
        }
        roomOut(biomObject.getBiom().get("JungleFloor").getFloor(floor));
    }

    public int getFloorSize()
    {
        return jungle._floorSize;
    }

    public int getRoomSize()
    {
        return jungle._roomSize;
    }

}
