package com.nuclearthinking.game.obj;

/**
 * Date: 22.12.2015
 * Time: 19:52
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class Player {

    private static final double DIFFICULITY = 1.0;
    private int hitPoints = 100;
    private int level = 1;
    private String name;
    private int strength = 10;
    private int intelligence = 10;
    private int agility = 10;
    private int stamina = 10;

    private Player() {
    }

    public static Player getInstance() {
        return PlayerHolder.INSTANCE;
    }

    public void levelUp() {
        level++;

    }

    private void addStrenght(int amount) {
        strength = strength + amount;
    }

    private void addIntelegence(int amount) {
        intelligence = intelligence + amount;
    }

    private void addAgility(int amount) {
        agility = agility + amount;
    }

    private void addStamina(int amount) {
        stamina = stamina + amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }


    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    private static class PlayerHolder {
        private static final Player INSTANCE = new Player();
    }
}
