package com.nuclearthinking.game.utils;

import com.nuclearthinking.game.obj.world.biome.*;

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

        int rndId = rUtil.randomInt(0,biomes.size());

        return biomes.get(rndId);
    }

}
