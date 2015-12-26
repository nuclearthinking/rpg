package com.nuclearthinking.game.config;

import java.io.File;

/**
 * Date: 24.12.2015
 * Time: 13:19
 *
 * @author kuksin-mv
 */
public class Config extends ConfigEngine
{
    private static final String EOL = File.separator;
    private static final String DIR = "config/";

    @ConfigField(config = "general", fieldName = "Debug", value = "false")
    public static boolean DEBUG;

    public static void load() throws Exception
    {
        loadConfig(Config.class, "general", DIR);
    }
}
