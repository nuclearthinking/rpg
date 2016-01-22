package com.nuclearthinking.game.obj.world2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kuksin-mv on 20.01.2016.
 */
public abstract class BiomObject
{
    public Map<String, Room> _biom = new HashMap<String, Room>();

    public Map<String, Room> getBiom()
    {
        return _biom;
    }

    public void setBiom(String key, Room value)
    {
        _biom.put(key, value);
    }

}
