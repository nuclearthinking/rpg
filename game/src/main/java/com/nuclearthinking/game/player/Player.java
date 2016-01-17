package com.nuclearthinking.game.player;

import com.nuclearthinking.game.characters.interfaces.IName;
import com.nuclearthinking.game.npc.Monster;

/**
 * Date: 11.01.2016
 * Time: 12:23
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 *
 * Пока что будет такой вот слабенький запил
 * CharacterObject - будет инстансится от Player
 * Npc - должен будет инстансится от CharacterObject
 * Нужно реализовать инстансы для создания разных объектов (Нпс, игрок и так далее)
 */

public class Player implements IName
{
    private int currentFloor;
    private int currentRoom;
    private int hitPoints = 100;
    private static final double DIFFICULITY = 1.0;
    private PlayerClass pClass;
    private int level = 1;
    private String name;
    private double strength = 10;
    private double intelligence = 10;
    private double agility = 10;
    private double stamina = 10;

    public Player(){}

    public void levelUP() {

        if (getpClass().isRogue()) {
            RogueClass rClass = new RogueClass();
            rClass.levelUp(this);
            this.level++;
        } else {
            if (getpClass().isMage()) {
                MageClass mClass = new MageClass();
                mClass.levelUp(this);
                this.level++;
            } else {
                if (getpClass().isWarrior()) {
                    WarriorClass wClass = new WarriorClass();
                    wClass.levelUp(this);
                    this.level++;
                } else {
                    throw new RuntimeException("У обьекта" + this.getName() + "не задан класс :" + pClass + "=" + pClass.toString());
                }
            }
        }
    }

    public int getPDef()
    {
        return getpClass().pDefence(this);
    }

    public int getPAtk()
    {
        return getpClass().pDamage(this);
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

    public void setClass(PlayerClass pClass) {
        this.pClass = pClass;
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

    public void updateHp(int dmg)
    {
        setHitPoints(hitPoints - dmg);
    }

    public void addDmg(Monster target)
    {
        addDmg(target, false);
    }

    public void addDmg(Monster target, boolean autoAtack)
    {
        while (true)
        {
            int test = getPAtk() / target.getPDef();
            double value = Math.random() * test;

            if (target.getHitPoints() - value <= 0)
            {
                target.fillDie();
                break;
            }

            if (value <= 1)
            {
                System.out.println("Вы промазали");
            }
            target.updateHp((int)value);

            if (!autoAtack)
            {
                break;
            }
        }
    }
}
