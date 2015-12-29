package com.nuclearthinking.game.obj.world;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 28.12.2015
 * Time: 15:44
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class World {

    protected World() {

    }

    private static class WorldHolder {
        private static final World INSTANCE = new World();
    }

    public static World getInstance() {
        return WorldHolder.INSTANCE;
    }

    private int size = 0;
    private List<Floor> worldArray;

    public void createWorld() {
        if (size == 0) {
            throw new RuntimeException("Размер мира не установлен");
        }
        int worldSize = size;
        worldArray = new ArrayList<Floor>();
        for (int i = 0; i < worldSize; i++) {
            worldArray.add(i, new Floor().generateFloor());
        }
    }

    public List<Floor> getWorldArray() {
        return worldArray;
    }

    //TODO: Метод для сохранения состояния мира
    public void save() {

    }

    public void setSize(int size) {
        this.size = size;
    }
}
