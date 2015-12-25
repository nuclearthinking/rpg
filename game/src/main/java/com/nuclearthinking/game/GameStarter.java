package com.nuclearthinking.game;

import com.nuclearthinking.game.config.Config;
import com.nuclearthinking.game.data.SkillData;
import com.nuclearthinking.game.model.skills.Skill;
import com.nuclearthinking.game.utils.UserInput;

import java.io.File;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created
 * Date: 23.12.2015
 * Time: 12:28
 *
 * @author kuksin-mv (onfient@gmail.com)
 */
public final class GameStarter {
    private static final Logger LOG = Logger.getLogger(GameStarter.class.getName());
    private static final String LOG_FOLDER = "log";
    private static final String LOG_NAME = "log.cfg";
    private static final String DIR = "game" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;

    public static GameStarter gameStarter;
    private UserInput input = new UserInput();

    public GameStarter() throws Exception {
//        printSection("Player load");
        SkillData.getInstance();
        Game.getInstance();


        //Секция для дебага. Настройка в general конфиге
        if (Config.DEBUG) {
            final Skill skill = SkillData.getInstance().getSkill(1, 10);
        }
    }

    public static void main(String[] args) throws Exception {
        File logFile = new File(DIR + LOG_FOLDER);
        logFile.mkdir();
        Config.load();
        gameStarter = new GameStarter();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("log.cfg");
        LogManager.getLogManager().readConfiguration(is);
    }


    public static void printSection(String s) {
        s = "=[ " + s + " ]";
        while (s.length() < 61) {
            s = "-" + s;
        }
        LOG.fine(s);
    }

    public InputStream getFileStream(String path) {
        return this.getClass().getResourceAsStream(path);

    }
}
