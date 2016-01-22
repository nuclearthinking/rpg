package com.nuclearthinking.game.utils;

import com.nuclearthinking.game.obj.world.Room;
import com.nuclearthinking.game.obj.world.biome.*;
import com.nuclearthinking.game.obj.world.rooms.BridgeRoom;
import com.nuclearthinking.game.obj.world.rooms.CityRoom;
import com.nuclearthinking.game.obj.world.rooms.DefaultRoom;
import com.nuclearthinking.game.obj.world.rooms.VillageRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 29.12.2015
 * Time: 10:14
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class WorldGenerateUtil {

    RandomUtil rUtil = new RandomUtil();

    public Biome getRandomBiome() {
        List<Biome> biomes = new ArrayList<Biome>();
        biomes.add(new DesertBiome());
        biomes.add(new JungleBiome());
        biomes.add(new PlainsBiome());
        biomes.add(new SwamplandBiome());
        biomes.add(new TaigaBiome());

        int rndId = rUtil.randomInt(0, biomes.size() - 1);

        return biomes.get(rndId);
    }

    public Room getRandomRoom() {
        List<Room> roomes = new ArrayList<>();
        roomes.add(new BridgeRoom());
        roomes.add(new CityRoom());
        roomes.add(new DefaultRoom());
        roomes.add(new VillageRoom());

        int rndId = rUtil.randomInt(0, roomes.size() - 1);

        return roomes.get(rndId);
    }

    public int getRnd(int min, int max)
    {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

}
