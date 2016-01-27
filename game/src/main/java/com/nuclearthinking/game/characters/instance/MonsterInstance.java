package com.nuclearthinking.game.characters.instance;

import com.nuclearthinking.game.characters.AttackableNpc;
import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.characters.templates.NpcTemplate;

/**
 * Date: 16.01.2016
 * Time: 12:09
 *
 * @author Izonami
 */
public class MonsterInstance extends AttackableNpc {

    public MonsterInstance(NpcTemplate template) {
        super(template);
    }

    @Override
    public boolean isMonster() {
        return true;
    }

    @Override
    public void onSpawn() {
        super.onSpawn();
    }

    @Override
    public boolean fillDie(CharacterObject killer) {
        if (!super.fillDie(killer)) {
            return false;
        }

        return true;
    }
}
