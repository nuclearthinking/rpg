package com.nuclearthinking.game.obj.world;

import com.nuclearthinking.game.obj.world.biome.Biome;
import com.nuclearthinking.game.utils.RandomUtil;
import com.nuclearthinking.game.utils.WorldGenerateUtil;

/**
 * Date: 28.12.2015
 * Time: 15:44
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */


public class Floor extends World {
    int minWidth = 0;
    int maxWidth = 0;
    int minHeight = 0;
    int maxHeight = 0;
    private RandomUtil rUtil = new RandomUtil();
    private Level level = new Level();
    private WorldGenerateUtil wGem = new WorldGenerateUtil();
    private Level[][] floorMap;
    private Biome floorBiome;

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    protected Floor generateFloor() {
        Floor floor = new Floor();
        checkWidthHeightValues();
        int width = rUtil.randomInt(minWidth, maxWidth);
        int height = rUtil.randomInt(minHeight, maxHeight);
        floorMap = new Level[height][width];
        for (int i = 0; i < height; i++) {
            for (int o = 0; o < width; o++) {
                floorMap[i][o] = level.generateLevel();
            }
        }
        floor.setFloorMap(floorMap);
        Biome randomedBiome = wGem.getRandomBiome();
        floor.setFloorBiome(randomedBiome);
        return floor;
    }

    private void checkWidthHeightValues() {
        if (minWidth == 0 | maxWidth == 0) {
            throw new RuntimeException("Не установленны минимальные и максимальные значения ширины этажа");
        }
        if (minHeight == 0 | maxHeight == 0) {
            throw new RuntimeException("Не установленны минимальные и максимальные значения высоты этажа");
        }
    }

    public void setFloorMap(Level[][] floorMap) {
        this.floorMap = floorMap;
    }

    public Biome getFloorBiome() {
        return floorBiome;
    }

    public void setFloorBiome(Biome floorBiome) {
        this.floorBiome = floorBiome;
    }
}
