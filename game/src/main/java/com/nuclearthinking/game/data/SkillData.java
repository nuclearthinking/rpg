package com.nuclearthinking.game.data;

import com.nuclearthinking.game.config.Config;
import com.nuclearthinking.game.engines.Engine;
import com.nuclearthinking.game.model.skills.Skill;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by kuksin-mv on 25.12.2015.
 * <p/>
 * Это класс лоадер скилов в котором будут храниться все скилы
 */
public class SkillData {
    private static Logger LOG = Logger.getLogger(SkillData.class.getName());

    private final Map<Integer, Skill> _skills = new HashMap<>();
    private final Map<Integer, Integer> _skillMaxLevel = new HashMap<>();

    protected SkillData() {
        load();
    }

    // Все что связано с хешем это запил на перезагрузку без перезапуска клиента, какой нибудь командой
    // Ну а главное так работать проще и быстрее будет
    public static int getSkillHashCode(Skill skill) {
        return getSkillHashCode(skill.getId(), skill.getLevel());
    }

    public static int getSkillHashCode(int skillId, int skillLevel) {
        return (skillId * 1021) + skillLevel;
    }

    public static SkillData getInstance() {
        return SingletonHolder._instance;
    }

    private void load() {
        final Map<Integer, Skill> _temp = new HashMap<>();
        //Затягиваем все скилы в мапу
        Engine.getInstance().loadAllSkills(_temp);

        // Чистим постоянную и складываем из темповой мапы в постоянную
        _skills.clear();
        _skills.putAll(_temp);

        _skillMaxLevel.clear();

        for (Skill skill : _skills.values()) {

            final int skillId = skill.getId();
            final int skillLvl = skill.getLevel();

            //Узнаем максимальный уровень умения и ложим его ид и уровень в мапу
            final int maxLvl = getMaxLevel(skillId);
            if (skillLvl > maxLvl) {
                _skillMaxLevel.put(skillId, skillLvl);
            }
        }
    }

    public int getMaxLevel(int skillId) {
        final Integer maxLevel = _skillMaxLevel.get(skillId);
        return maxLevel != null ? maxLevel : 0;
    }

    //Тут для нуждающихся будем отдавать ид скила и уровень
    public Skill getSkill(int skillId, int level) {
        final Skill result = _skills.get(getSkillHashCode(skillId, level));

        if (result != null) {
            if (Config.DEBUG) {
                System.out.println("Skill Name: " + result.getName());
                System.out.println("Skill Id: " + result.getId());
                System.out.println("Skill Lvl: " + getMaxLevel(result.getId()));
            }
            return result;
        }

        LOG.log(Level.WARNING, getClass().getSimpleName() + ": No skill info found for skill id " + skillId + " and skill level " + level + ".");
        return null;
    }

    private static class SingletonHolder {
        protected static final SkillData _instance = new SkillData();
    }
}
