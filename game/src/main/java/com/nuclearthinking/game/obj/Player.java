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
    private PlayerClass pClass;
    private int level = 1;
    private String name;
    private double strength = 10;
    private double intelligence = 10;
    private double agility = 10;
    private double stamina = 10;

    private Player() {
    }

    public static Player getInstance() {
        return PlayerHolder.INSTANCE;
    }


    public void levelUP() {

        if (getpClass() instanceof RogueClass) {
            RogueClass.getInstance().levelUp(this);
            this.level++;
        }
    }

    protected void addStrenght(double amount) {
        strength = strength + amount;
    }

    protected void addIntelegence(double amount) {
        intelligence = intelligence + amount;
    }

    protected void addAgility(double amount) {
        agility = agility + amount;
    }

    protected void addStamina(double amount) {
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

    public PlayerClass getpClass() {
        return pClass;
    }

    public void setClass(PlayerClass pClass) {
        this.pClass = pClass;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public double getStrength() {
        return strength;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public double getAgility() {
        return agility;
    }

    public double getStamina() {
        return stamina;
    }

    private static class PlayerHolder {
        private static final Player INSTANCE = new Player();
    }
}
