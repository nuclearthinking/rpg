package com.nuclearthinking.game.characters;

import com.nuclearthinking.game.characters.stats.Calculator;
import com.nuclearthinking.game.characters.stats.Formulas;
import com.nuclearthinking.game.characters.stats.functions.AbstractFunction;
import com.nuclearthinking.game.characters.templates.CharacterTemplate;
import com.nuclearthinking.game.enums.Race;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Date: 22.12.2015
 * Time: 19:52
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class Player extends GameCharacter
{
    private volatile Set<Player> _attackByList;
    private volatile boolean _isCastingNow = false;
    private Skill _lastSkillCast;

    private boolean _isDead = false;

    private Calculator[] _calculators;
    private final Map<Integer, Skill> _skills = new ConcurrentHashMap<>();
    //Тут будем хранить время реюзов скилов
    //Я придумал как реализовать, но пока что вливать не буду
    //private volatile Map<Integer, ReuseTime> _reuseTimeStampsSkills = null;
    private volatile Map<Integer, Long> _disabledSkills = null;
    private boolean _allSkillsDisabled;

    //Это цель для атаки
    private GameCharacter _target;

    private CharacterTemplate _template;

    private static final double DIFFICULITY = 1.0;


    //TODO: Все присвоение статов нужно будет вынести в отдельный инстанс класс, который будет собирать персонажа
    private PlayerClass pClass;
    private int level = 1;
    private String name;
    private double strength = 10;
    private double intelligence = 10;
    private double agility = 10;
    private double stamina = 10;

    public Player(int objectId, CharacterTemplate template)
    {
        super(objectId);

        if (template == null)
        {
            throw new NullPointerException("Template is null");
        }

        _template = template;

        if (isNpc())
        {
            for(Skill skill : template.getSkills().values())
            {
                //TODO: Тут будут добавляться заданные скилы для нпс
                //addSkill(skill);
            }
        }
        else
        {
            _calculators = new Calculator[Stats.NUM_STATS];
            Formulas.addFuncsToNewCharacter(this);
        }
    }

    public void levelUP() {

        if (getpClass() instanceof RogueClass) {
            RogueClass rClass = new RogueClass();
            rClass.levelUp(this);
            this.level++;
        } else {
            if (getpClass() instanceof MageClass) {
                MageClass mClass = new MageClass();
                mClass.levelUp(this);
                this.level++;
            } else {
                if (getpClass() instanceof WarriorClass) {
                    WarriorClass wClass = new WarriorClass();
                    wClass.levelUp(this);
                    this.level++;
                } else {
                    throw new RuntimeException("У обьекта" + this.getName() + "не задан класс :" + pClass + "=" + pClass.toString());
                }
            }
        }
    }

    @Override
    public void onSpawn()
    {
        super.onSpawn();
        //TODO: Позицию
    }


    public void doCast(Skill skill)
    {
        beginCast(skill, false);
    }

    private void beginCast(Skill skill, boolean boo)
    {
        //TODO: Тут будет определение типа скила
        Player target = null;

        beginCast(skill, boo, target);
    }

    private void beginCast(Skill skill, boolean simultaneously, Player target)
    {

    }

    public boolean checkDoCastConditions(Skill skill)
    {
        //TODO: Тут будем проверять состояния возможности каста
        return false;
    }

    //TODO: Реализовать состояния при которых игрок не сможет совершать действия (например в стуне)


    public final boolean isCastingNow()
    {
        return _isCastingNow;
    }

    public void setIsCastingNow(boolean value)
    {
        _isCastingNow = value;
    }

    public void setTarget(GameCharacter object)
    {
        if (object != null)
        {
            object = null;
        }

        if ((object != null) && (object != _target))
        {
            //TODO: Тут надо сделать список целей
        }
        _target = object;
    }

    public final int getTargetId()
    {
        if (_target != null)
        {
            return _target.getObjectId();
        }
        return 0;
    }

    public final GameCharacter getTarget()
    {
        return _target;
    }

    @Override
    public boolean isCharacter()
    {
        return true;
    }

    public Race getRace()
    {
        return getTemplate().getRace();
    }

    public CharacterTemplate getTemplate()
    {
        return _template;
    }

    public final void setTemplate(CharacterTemplate template)
    {
        _template = template;
    }

    public final void addStatFunc(AbstractFunction function)
    {
        if (function == null)
        {
            return;
        }

        synchronized (this)
        {
            int stat = function.getStat().ordinal();

            if (_calculators[stat] == null)
            {
                _calculators[stat] = new Calculator();
            }

            _calculators[stat].addFunc(function);
        }
    }





    //TODO: Убрать все расчеты оставить только гетеры в которых будут браться статы расчитанные в другом классе
    // Например
    public int getSTR()
    {
        return 0;//getStat().getSTR();
    }

    public int getMAtkSpd()
    {
        return 1; //getMAtkSpd();
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

}
