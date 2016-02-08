package com.nuclearthinking.game.player;

import com.nuclearthinking.game.app.alldrow.SpriteAnimation;
import com.nuclearthinking.game.app.controller.Input;
import com.nuclearthinking.game.app.utils.ManagerResources;
import com.nuclearthinking.game.npc.Monster;
import com.nuclearthinking.game.obj.AbstractObject;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

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

public class Player extends AbstractObject
{
    private int _currentFloor;
    private int _currentRoom;
    private PlayerClass _pClass;
    private int _level = 1;
    private int _exp = 0;
    private int[] _expForLvlUp = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

    //Спрайт с игроком
    private final Image PLAYER = ManagerResources.loadImage("img\\gm.png");
    //Создаем представление со спрайтом игрока
    private final ImageView imageView = new ImageView(PLAYER);
    //Размер игрока (именно прямоугольник рисунка, а не всей картинки)
    private static final int SPRITE_WIDTH = 70;
    private static final int SPRITE_HEIGHT = 124;
    //Сколько всего колонок с анимацией игрока
    private static final int COLUMNS = 8;
    //По сути частота кадров для одной анимации
    private static final int COUNT = 4;
    //Смещение по спрайту
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 0;

    public Player()
    {
        super();
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, SPRITE_WIDTH, SPRITE_HEIGHT));
        spriteAnimation = new SpriteAnimation(this.imageView, Duration.millis(500), COUNT, COLUMNS, OFFSET_X, OFFSET_Y, SPRITE_WIDTH, SPRITE_HEIGHT);
        getChildren().add(imageView);
    }

    public void input(Input input)
    {
        if(input.isMoveRight())
        {
            spriteAnimation.setOffsetY(SPRITE_HEIGHT * 2);
            this.setTranslateX(this.getTranslateX() + (input.isRun()?5:1));
            spriteAnimation.play();
        }
        else if(input.isMoveLeft())
        {
            spriteAnimation.setOffsetY(SPRITE_HEIGHT);
            this.setTranslateX(this.getTranslateX() - (input.isRun()?5:1));
            spriteAnimation.play();
        }
        else if(input.isMoveUp())
        {
            spriteAnimation.setOffsetY(SPRITE_HEIGHT * 3);
            this.setTranslateY(this.getTranslateY() - (input.isRun()?5:1));
            spriteAnimation.play();
        }
        else if(input.isMoveDown())
        {
            spriteAnimation.setOffsetY(0);
            this.setTranslateY(this.getTranslateY() + (input.isRun()?5:1));
            spriteAnimation.play();
        }
        else
        {
            //Топорно но лучше чем spriteAnimation.stop(); при нем персонаж начинает с пробуксовки
            spriteAnimation.pause();
        }
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
