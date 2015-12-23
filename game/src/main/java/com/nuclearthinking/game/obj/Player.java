package com.nuclearthinking.game.obj;

/**
 * Date: 22.12.2015
 * Time: 19:52
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class Player {

    private Player() {
    }

    private static class PlayerHolder {
        private static final Player INSTANCE = new Player();
    }

    public static Player getInstance() {
        return PlayerHolder.INSTANCE;
    }

    private int hitPoints = 100;
    private PlayerClass pClass;
    private int level = 1;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PlayerClass getpClass() {
        return pClass;
    }

    public void setpClass(PlayerClass pClass) {
        this.pClass = pClass;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
