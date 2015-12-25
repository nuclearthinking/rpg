package com.nuclearthinking.game.model.interfaces;

/**
 * Created by kuksin-mv on 24.12.2015.
 */
public interface IParserAdvUtils extends IParserUtils {
    boolean getBoolean(String key);

    byte getByte(String key);

    short getShort(String key);

    int getInt(String key);

    long getLong(String key);

    float getFloat(String key);

    double getDouble(String key);

    String getString(String key);

    <T extends Enum<T>> T getEnum(String key, Class<T> clazz);
}
