package com.nuclearthinking.game.config;

/**
 * Created by kuksin-mv on 24.12.2015.
 */
public class Config extends ConfigEngine
{
    //TODO: Это для дебага в IDE при компиле в джарник надо указывать другой путь
    private static final String DIR = System.getProperty("user.dir") + "\\game\\src\\main\\resources\\config\\";

    @ConfigField(config = "general", fieldName = "welcomMsg", value = "Добро пожаловать")
    public static String WELCOME_MSG;

    public static void load() throws Exception
    {
        loadConfig(Config.class, "general", DIR);
    }
}
