package com.nuclearthinking.game.config;

import java.util.Properties;

/**
 * Date: 24.12.2015
 * Time: 13:44
 *
 * @author kuksin-mv
 */
public class ExProperties extends Properties {
    public String getProperty(String name) {
        return getProperty(name.trim(), null);
    }

    public String getProperty(String name, String def) {
        String s = super.getProperty(name);
        return s == null ? def : s;
    }

    public int getIntProperty(String name, String def) {
        int defInt = 0;
        try {
            defInt = Integer.parseInt(def);
        } catch (Exception e) {

        }

        return getIntProperty(name, defInt);
    }

    public int getIntProperty(String name, int def) {
        String s = getProperty(name);

        return s == null ? def : Integer.parseInt(s.trim());
    }

    public long getLongProperty(String name, String def) {
        long defLong = 0;
        try {
            defLong = Long.parseLong(def);
        } catch (Exception e) {

        }

        return getLongProperty(name, defLong);
    }


    public long getLongProperty(String name, long def) {
        String s = getProperty(name);
        return s == null ? def : Long.parseLong(s.trim());
    }

    public byte getByteProperty(String name, String def) {
        byte defByte = 0;
        try {
            defByte = Byte.parseByte(def);
        } catch (Exception e) {

        }

        return getByteProperty(name, defByte);
    }

    public byte getByteProperty(String name, byte def) {
        String s = getProperty(name);
        return s == null ? def : Byte.parseByte(s.trim());
    }

    public byte getByteProperty(String name, int def) {
        return getByteProperty(name, (byte) def);
    }

    public boolean getBooleanProperty(String name, String def) {
        boolean defBoolean = false;
        try {
            defBoolean = Boolean.parseBoolean(def);
        } catch (Exception e) {

        }

        return getBooleanProperty(name, defBoolean);
    }

    public boolean getBooleanProperty(String name, boolean def) {
        String s = getProperty(name);
        return s == null ? def : Boolean.parseBoolean(s.trim());
    }

    public float getFloatProperty(String name, String def) {
        float defFloat = 0;
        try {
            defFloat = Float.parseFloat(def);
        } catch (Exception e) {

        }

        return getFloatProperty(name, defFloat);
    }

    public float getFloatProperty(String name, float def) {
        String s = getProperty(name);
        return s == null ? def : Float.parseFloat(s.trim());
    }

    public float getFloatProperty(String name, double def) {
        return getFloatProperty(name, (float) def);
    }

    public double getDoubleProperty(String name, String def) {
        double defDouble = 0;
        try {
            defDouble = Double.parseDouble(def);
        } catch (Exception e) {

        }

        return getDoubleProperty(name, defDouble);
    }

    public double getDoubleProperty(String name, double def) {
        String s = getProperty(name);
        return s == null ? def : Double.parseDouble(s.trim());
    }
}
