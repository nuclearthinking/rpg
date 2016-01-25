package com.nuclearthinking.game.obj.world2.biome;

import com.nuclearthinking.game.obj.world2.Floors;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kuksin-mv on 20.01.2016.
 */
public abstract class BiomObject
{
    private Map<String, Floors> _biom = new HashMap<String, Floors>();

    public Map<String, Floors> getBiom()
    {
        return _biom;
    }

    public void setBiom(String key, Floors value)
    {
        _biom.put(key, value);
    }

    public int getBiomSize()
    {
        return _biom.size();
    }

}
