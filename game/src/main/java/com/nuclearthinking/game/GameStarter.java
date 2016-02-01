package com.nuclearthinking.game;

import com.nuclearthinking.game.config.Config;
import com.nuclearthinking.game.data.ItemData;
import com.nuclearthinking.game.data.SkillData;
import com.nuclearthinking.game.engines.DatabaseEngine;
import com.nuclearthinking.game.utils.ResourceUtil;

/**
 * Created
 * Date: 23.12.2015
 * Time: 12:28
 *
 * @author kuksin-mv
 */
public final class GameStarter {
    //private static final Logger LOG = Logger.getLogger(GameStarter.class.getName());

    private static final String LOG_FOLDER = "log";
    private static final String LOG_NAME = "log.cfg";

    private static final ResourceUtil resource = new ResourceUtil();


    public GameStarter() throws Exception
    {
        //Загрузка конфига
        Config.load();
        //Загрузка скилов
        SkillData.getInstance();
        //Загрузка итемов
        ItemData.getInstance();
        //Инициализация базы данных
        DatabaseEngine.getInstance().initDb();

        //Создание мира
        //World world = new WorldManager(30).getWorld();
        //Запуск игры
        //new MainGameLoop(player, world);

        //Секция для дебага. Настройка в general конфиге
        if (Config.DEBUG)
        {
            SkillData.getInstance().getSkill(1, 10);
            ItemData.getInstance().getForDebug(1);
        }
    }

    /*public static void main(String[] args) throws Exception {
        File logFile = new File(LOG_FOLDER);
        logFile.mkdir();
        Config.load();
        new GameStarter();
        InputStream is = resource.getResourceAsStream(LOG_NAME);
        LogManager.getLogManager().readConfiguration(is);
    }*/
}
