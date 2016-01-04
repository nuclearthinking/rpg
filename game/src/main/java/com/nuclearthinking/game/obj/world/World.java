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

    protected int size = 0;
    private List<Floor> worldArray;
    public World() {
    }

    public void createWorld() {
        if (size == 0) {
            throw new RuntimeException("Размер мира не установлен");
        }
        int worldSize = size;
        worldArray = new ArrayList<Floor>();
        for (int i = 0; i < worldSize; i++) {
            worldArray.add(i, new Floor().generateFloor());
        }
        floorNumbering(worldArray);
    }

    public List<Floor> getWorldArray() {
        return worldArray;
    }

    //TODO: Метод для сохранения состояния мира
    public void save() {
    }

    public World setSize(int size) {
        this.size = size;
        return this;
    }

    public void floorNumbering(List<Floor> worldArray) {
        int n = 1;
        for (Floor floor : worldArray) {
            floor.setFloorId(n);
            n++;
        }
    }

    public Floor getFloorById(int id) {
        if (id <= 0 | id > worldArray.size()) {
            throw new RuntimeException("Несуществующий Floor ID");
        }
        return worldArray.get(id - 1);
    }
}
