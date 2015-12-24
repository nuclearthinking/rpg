package com.nuclearthinking.game.model;

import com.nuclearthinking.game.model.interfaces.IParserAdvUtils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by kuksin-mv on 24.12.2015.
 */
public class StatsSet implements IParserAdvUtils
{
    private static final Logger _log = Logger.getLogger(StatsSet.class.getName());

    public static final StatsSet EMPTY_STATSET = new StatsSet(Collections.<String, Object> emptyMap());

    private final Map<String, Object> _set;

    public StatsSet()
    {
        this(new LinkedHashMap<>());
    }

    public StatsSet(Map<String, Object> map)
    {
        _set = map;
    }

    public final Map<String, Object> getSet()
    {
        return _set;
    }

    public void add(StatsSet newSet)
    {
        _set.putAll(newSet.getSet());
    }

    public boolean isEmpty()
    {
        return _set.isEmpty();
    }

    //TODO: Сделать для остальных по аналогии
    @Override
    public boolean getBoolean(String key)
    {
        Object val = _set.get(key);
        if (val == null)
        {
            throw new IllegalArgumentException("Boolean value required, but not specified");
        }
        if (val instanceof Boolean)
        {
            return ((Boolean) val).booleanValue();
        }
        try
        {
            return Boolean.parseBoolean((String) val);
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Boolean value required, but found: " + val);
        }
    }

    @Override
    public byte getByte(String key) {
        return 0;
    }

    @Override
    public short getShort(String key) {
        return 0;
    }

    @Override
    public int getInt(String key)
    {
        final Object val = _set.get(key);
        if (val == null)
        {
            throw new IllegalArgumentException("Integer value required, but not specified: " + key + "!");
        }

        if (val instanceof Number)
        {
            return ((Number) val).intValue();
        }

        try
        {
            return Integer.parseInt((String) val);
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Integer value required, but found: " + val + "!");
        }
    }

    @Override
    public long getLong(String key) {
        return 0;
    }

    @Override
    public float getFloat(String key) {
        return 0;
    }

    @Override
    public double getDouble(String key) {
        return 0;
    }

    @Override
    public String getString(String key)
    {
        Object val = _set.get(key);
        if (val == null)
        {
            throw new IllegalArgumentException("String value required, but not specified");
        }
        return String.valueOf(val);
    }

    @Override
    public <T extends Enum<T>> T getEnum(String key, Class<T> clazz) {
        return null;
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return false;
    }

    @Override
    public byte getByte(String key, byte defaultValue) {
        return 0;
    }

    @Override
    public short getShort(String key, short defaultValue) {
        return 0;
    }

    @Override
    public int getInt(String key, int defaultValue)
    {
        Object val = _set.get(key);
        if (val == null)
        {
            return defaultValue;
        }
        if (val instanceof Number)
        {
            return ((Number) val).intValue();
        }
        try
        {
            return Integer.parseInt((String) val);
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Integer value required, but found: " + val);
        }
    }

    @Override
    public long getLong(String key, long defaultValue) {
        return 0;
    }

    @Override
    public float getFloat(String key, float defaultValue) {
        return 0;
    }

    @Override
    public double getDouble(String key, double defaultValue) {
        return 0;
    }

    @Override
    public String getString(String key, String defaultValue)
    {
        Object val = _set.get(key);
        if (val == null)
        {
            return defaultValue;
        }
        return String.valueOf(val);
    }

    @Override
    public <T extends Enum<T>> T getEnum(String key, Class<T> clazz, T defaultValue) {
        return null;
    }
}
