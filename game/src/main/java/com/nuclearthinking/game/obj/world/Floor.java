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
    protected Room[][] floorMap;
    int minWidth = 4;
    int maxWidth = 7;
    int minHeight = 3;
    int maxHeight = 8;
    boolean visited = false;
    int floorSize;
    private RandomUtil rUtil = new RandomUtil();
    private WorldGenerateUtil wGem = new WorldGenerateUtil();
    private Biome floorBiome;
    private int floorId;

    public Room[][] getFloorMap() {
        return floorMap;
    }

    public void setFloorMap(Room[][] floorMap) {
        this.floorMap = floorMap;
    }

    public int getFloorSize() {
        return floorSize;
    }

    public void setFloorSize(int floorSize) {
        this.floorSize = floorSize;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

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
        floorMap = new Room[height][width];
        for (int i = 0; i < height; i++) {
            for (int o = 0; o < width; o++) {
                floorMap[i][o] = new Room().generateRoom();
            }
        }
        floor.setFloorMap(floorMap);
        Biome randomedBiome = wGem.getRandomBiome();
        floor.setFloorBiome(randomedBiome);
        floor.setFloorSize(width * height);
        roomNumbering(floorMap);
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

    public Biome getFloorBiome() {
        return floorBiome;
    }

    public void setFloorBiome(Biome floorBiome) {
        this.floorBiome = floorBiome;
    }


    private void roomNumbering(Room[][] rooms) {
        int y = 1;
        for (int i = 0; i < rooms.length; i++) {
            for (int o = 0; o < rooms[0].length; o++) {
                rooms[i][o].setRoomId(y);
                y++;
            }
        }
    }

    public Room getRoomById(int id) {
        if (id <= 0 & id > floorMap.length) {
            throw new RuntimeException("Некорректный Room ID");
        }
        if (floorMap == null) {
            throw new RuntimeException("У этажа отсутсвтуют комнаты");
        }
        for (int i = 0; i < floorMap.length; i++) {
            for (int o = 0; o < floorMap[0].length; o++) {
                if (floorMap[i][o].getRoomId() == id) {
                    return floorMap[i][o];
                }
            }
        }
        return null;
    }
}
