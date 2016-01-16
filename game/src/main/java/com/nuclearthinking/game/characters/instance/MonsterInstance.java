package com.nuclearthinking.game.characters.instance;

import com.nuclearthinking.game.characters.AttackableNpc;
import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.characters.templates.NpcTemplate;

/**
 * Created by Izonami on 16.01.2016.
 */
public class MonsterInstance extends AttackableNpc
{

    public MonsterInstance(NpcTemplate template)
    {
        super(template);
    }

    @Override
    public boolean isMonster()
    {
        return true;
    }

    @Override
    public void onSpawn()
    {
        super.onSpawn();
    }

    @Override
    public boolean fillDie(CharacterObject killer)
    {
        if (!super.fillDie(killer))
        {
            return false;
        }

        return true;
    }
}
