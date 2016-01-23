package com.nuclearthinking.game.player;

import com.nuclearthinking.game.npc.Monster;
import com.nuclearthinking.game.obj.AbstractObject;

/**
 * Date: 11.01.2016
 * Time: 12:23
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 *         <p>
 *         Пока что будет такой вот слабенький запил
 *         CharacterObject - будет инстансится от Player
 *         Npc - должен будет инстансится от CharacterObject
 *         Нужно реализовать инстансы для создания разных объектов (Нпс, игрок и так далее)
 */

public class Player extends AbstractObject {
    private int _currentFloor;
    private int _currentRoom;
    private PlayerClass _pClass;
    private int _level = 1;
    private int _exp = 0;
    private int[] _expForLvlUp = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

    public Player() {
        super();
    }

    public void levelUP() {

        if (getpClass().isRogue()) {
            RogueClass rClass = new RogueClass();
            rClass.levelUp(this);
            initStat();
            _level++;
        } else {
            if (getpClass().isMage()) {
                MageClass mClass = new MageClass();
                mClass.levelUp(this);
                initStat();
                _level++;
            } else {
                if (getpClass().isWarrior()) {
                    WarriorClass wClass = new WarriorClass();
                    wClass.levelUp(this);
                    initStat();
                    _level++;
                } else {
                    throw new RuntimeException("У обьекта" + this.getName() + "не задан класс :" + _pClass + "=" + _pClass.toString());
                }
            }
        }
    }

    public int getPDef() {
        return getpClass().pDefence(this);
    }

    public int getPAtk() {
        return getpClass().pDamage(this);
    }

    public int getCurrentFloor() {
        return _currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        _currentFloor = currentFloor;
    }

    public int getCurrentRoom() {
        return _currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        _currentRoom = currentRoom;
    }

    public PlayerClass getpClass() {
        return _pClass;
    }

    public int getLevel() {
        return _level;
    }

    public void setLevel(int lvl) {
        _level = lvl;
    }

    public void setClass(PlayerClass pClass) {
        _pClass = pClass;
    }

    public void addStrenght(double amount) {
        _strength += amount;
    }

    public void addIntelegence(double amount) {
        _intelligence += amount;
    }

    public void addAgility(double amount) {
        _agility += amount;
    }

    public void addStamina(double amount) {
        _stamina += amount;
    }

    public void addDmg(Monster target) {
        addDmg(target, false);
    }

    public void addDmg(Monster target, boolean autoAtack) {
        if (target.isDead()) {
            return;
        }

        while (true) {
            int test = getPAtk() / target.getPDef();
            double value = Math.random() * test;

            if (target.getHitPoints() - value <= 0) {
                target.fillDie(this);
                break;
            }

            if (value <= 1) {
                System.out.println("Вы промазали");
            }
            target.updateHp((int) value);

            if (!autoAtack) {
                break;
            }
        }
    }

    public int getExp() {
        return _exp;
    }

    public void setExp(int exp) {
        if (getLevel() >= _expForLvlUp.length) {
            System.out.println("Максимальный уровень");
            return;
        }

        int tmp = getExp() + exp;

        if (tmp >= _expForLvlUp[getLevel()]) {
            levelUP();
        } else {
            _exp = _exp + exp;
        }
    }
}
