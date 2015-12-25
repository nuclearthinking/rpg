package com.nuclearthinking.game.config;

import java.io.File;

/**
 * Date: 24.12.2015
 * Time: 13:19
 *
 * @author kuksin-mv
 */
public class Config extends ConfigEngine {
    //TODO: Это для дебага в IDE при компиле в джарник надо указывать другой путь
    private static final String DIR = "game" + File.separator + "src" + File.separator +"main"+ File.separator+ "resources" + File.separator + "config" +File.separator;


    @ConfigField(config = "general", fieldName = "Debug", value = "false")
    public static boolean DEBUG;

    public static void load() throws Exception {
        loadConfig(Config.class, "general", DIR);
    }
}
