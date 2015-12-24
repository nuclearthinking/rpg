package com.nuclearthinking.game.model.interfaces;

/**
 * Created by kuksin-mv on 24.12.2015.
 */
public interface IParserUtils
{
    boolean getBoolean(String key, boolean defaultValue);

    byte getByte(String key, byte defaultValue);

    short getShort(String key, short defaultValue);

    int getInt(String key, int defaultValue);

    long getLong(String key, long defaultValue);

    float getFloat(String key, float defaultValue);

    double getDouble(String key, double defaultValue);

    String getString(String key, String defaultValue);

    <T extends Enum<T>> T getEnum(String key, Class<T> clazz, T defaultValue);
}
