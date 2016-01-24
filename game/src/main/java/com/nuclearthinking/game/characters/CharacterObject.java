package com.nuclearthinking.game.characters;

import com.nuclearthinking.game.characters.stats.Calculator;
import com.nuclearthinking.game.characters.stats.CharacterStat;
import com.nuclearthinking.game.characters.stats.Formulas;
import com.nuclearthinking.game.characters.stats.functions.AbstractFunction;
import com.nuclearthinking.game.characters.status.CharacterStatus;
import com.nuclearthinking.game.characters.templates.CharacterTemplate;
import com.nuclearthinking.game.enums.Race;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.ReuseTime;
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

public abstract class CharacterObject extends GameObject {
    //Тут будем хранить время реюзов скилов
    private volatile Map<Integer, ReuseTime> _reuseTimeStampsSkills = null;
    private volatile Map<Integer, Long> _disabledSkills = null;
    private volatile Set<CharacterObject> _attackByList;
    private volatile boolean _isCastingNow = false;

    private boolean _isDead = false;
    private boolean _allSkillsDisabled;

    private int level = 1;

    private Calculator[] _calculators;

    private final Map<Integer, Skill> _skills = new ConcurrentHashMap<>();

    //Это цель для атаки
    private GameObject _target;

    private CharacterStat _stat;
    private CharacterStatus _status;
    private CharacterTemplate _template;

    public CharacterObject() {
    }

    public CharacterObject(int objectId, CharacterTemplate template) {
        super(objectId);

        if (template == null) {
            throw new NullPointerException("Template is null");
        }

        initCharacterStat();
        initCharacterStatus();

        _template = template;

        if (isNpc()) {
            for (Skill skill : template.getSkills().values()) {
                //TODO: Тут будут добавляться заданные скилы для нпс
                //addSkill(skill);
            }
        } else {
            System.out.println(Stats.NUM_STATS);
            _calculators = new Calculator[Stats.NUM_STATS];
            Formulas.addFuncsToNewCharacter(this);
            /*for (int i = 0; i < _calculators.length; i++) {
                System.out.println(_calculators[i]);
            }*/
        }
    }

    @Override
    public void onSpawn() {
        super.onSpawn();
        //TODO: Позицию
    }


    public void doCast(Skill skill) {
        beginCast(skill, false);
    }

    private void beginCast(Skill skill, boolean boo) {
        //TODO: Тут будет определение типа скила
        CharacterObject target = null;

        beginCast(skill, boo, target);
    }

    private void beginCast(Skill skill, boolean simultaneously, CharacterObject target) {

    }

    public boolean checkDoCastConditions(Skill skill) {
        //TODO: Тут будем проверять состояния возможности каста
        return false;
    }

    //TODO: Реализовать состояния при которых игрок не сможет совершать действия (например в стуне)

    public final boolean isCastingNow() {
        return _isCastingNow;
    }

    public void setIsCastingNow(boolean value) {
        _isCastingNow = value;
    }

    public void setTarget(GameObject object) {
        if (object != null) {
            object = null;
        }

        if ((object != null) && (object != _target)) {
            //TODO: Тут надо сделать список целей
        }
        _target = object;
    }

    public final int getTargetId() {
        if (_target != null) {
            return _target.getObjectId();
        }
        return 0;
    }

    public final GameObject getTarget() {
        return _target;
    }

    @Override
    public boolean isCharacter() {
        return true;
    }

    public Race getRace() {
        return getTemplate().getRace();
    }

    public CharacterTemplate getTemplate() {
        return _template;
    }

    public final void setTemplate(CharacterTemplate template) {
        _template = template;
    }

    public final void addStatFunc(AbstractFunction function) {
        if (function == null) {
            return;
        }

        int stat = function.getStat().ordinal();

        if (_calculators[stat] == null) {
            _calculators[stat] = new Calculator();
        }

        _calculators[stat].addFunc(function);
    }

    public void decreaseCurrentHp(double damage, CharacterObject attacker) {
        getStatus().updateHp(damage, attacker);
    }

    public final Calculator[] getCalculators() {
        return _calculators;
    }

    public CharacterStat getStat() {
        return _stat;
    }

    public void initCharacterStat() {
        _stat = new CharacterStat(this);
    }

    public final void setStat(CharacterStat value) {
        _stat = value;
    }

    public CharacterStatus getStatus() {
        return _status;
    }

    public void initCharacterStatus() {
        _status = new CharacterStatus(this);
    }

    public void setStatus(CharacterStatus value) {
        _status = value;
    }

    public final boolean isDead() {
        return _isDead;
    }

    public final void setIsDead(boolean value) {
        _isDead = value;
    }

    public boolean fillDie(CharacterObject killer) {
        if (isDead()) {
            return false;
        }

        setCurrentHp(0);
        setIsDead(true);

        return true;
    }

    //TODO: Убрать все расчеты оставить только гетеры в которых будут браться статы расчитанные в другом классе
    // BASIC STATS
    /*STAT_STR("STR"),
    STAT_CON("CON"),
    STAT_DEX("DEX"),
    STAT_INT("INT"),
    STAT_WIT("WIT"),
    STAT_MEN("MEN");

    MAX_HP("maxHp"),
    MAX_MP("maxMp"),
    MAX_RECOVERABLE_HP("maxRecoverableHp"),
    MAX_RECOVERABLE_MP("maxRecoverableMp"),
    REGENERATE_HP_RATE("regHp"),
    REGENERATE_MP_RATE("regMp"),

    POWER_DEFENCE("pDef"),
    MAGIC_DEFENCE("mDef"),
    POWER_ATTACK("pAtk"),
    MAGIC_ATTACK("mAtk"),
    */

    public int getMaxHp() {
        return getStat().getMaxHp();
    }

    public int getMaxMp() {
        return getStat().getMaxMp();
    }

    public int getMaxHpRegen() {
        return getStat().getMaxHpRegen();
    }

    public int getMaxMpRegen() {
        return getStat().getMaxMpRegen();
    }

    public int getPDef() {
        return getStat().getPDef();
    }

    public int getMDef() {
        return getStat().getMDef();
    }

    public int getPAtk() {
        return getStat().getPAtk();
    }

    public int getMAtk() {
        return getStat().getMAtk();
    }

    public int getPAtkSpd() {
        return getStat().getPAtkSpd();
    }

    public int getMAtkSpd() {
        return getStat().getMAtkSpd();
    }

    public int getSTR() {
        return getStat().getSTR();
    }

    public int getCON() {
        return getStat().getCON();
    }

    public int getDEX() {
        return getStat().getDEX();
    }

    public int getINT() {
        return getStat().getINT();
    }

    public int getWIT() {
        return getStat().getWIT();
    }

    public int getMEN() {
        return getStat().getMEN();
    }

    public final double getCurrentHp() {
        return getStatus().getCurrentHp();
    }

    public final void setCurrentHp(double newHp) {
        getStatus().setCurrentHp(newHp);
    }

    public int getLevel() {
        return level;
    }
}
