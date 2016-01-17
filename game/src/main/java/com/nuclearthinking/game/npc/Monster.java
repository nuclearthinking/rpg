package com.nuclearthinking.game.npc;

import com.nuclearthinking.game.player.PlayerClass;

/**
 * Created by Izonami on 17.01.2016.
 */
public class Monster
{
    private int currentFloor;
    private int currentRoom;
    private int hitPoints = 100;
    private static final double DIFFICULITY = 1.0;
    private PlayerClass pClass;
    private byte level = 1;
    private String name;
    private double strength = 10;
    private double intelligence = 10;
    private double agility = 10;
    private double stamina = 10;

    public Monster(String name, byte level, int hp)
    {
        setName(name);
        setLevel(level);
        setStat(hp);
    }

    public int getPDef()
    {
        return (int) getStrength() / 2;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
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

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level)
    {
        this.level = level;
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

    public void setStat(int hp)
    {
        setHitPoints(hp);
    }

    public void updateHp(int dmg)
    {
        setHitPoints(hitPoints - dmg);
    }

    public void fillDie()
    {
        System.out.println("Monster Die");
        setHitPoints(0);
        getReward();
    }

    public void getReward()
    {
        System.out.println("Ваша награда");
    }
}
