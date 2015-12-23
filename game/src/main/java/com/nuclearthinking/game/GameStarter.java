package com.nuclearthinking.game;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created
 * Date: 23.12.2015
 * Time: 12:28
 *
 * @author kuksin-mv (onfient@gmail.com)
 */
public final class GameStarter {
    private static final Logger LOG = LoggerFactory.getLogger(GameStarter.class);
    private static final String LOG_FOLDER = "log";
    private static final String LOG_NAME = "./log.cfg";

    public static GameStarter gameStarter;

    public GameStarter() throws Exception {
        printSection("Player load");
        //TODO: Player.getInstance();
    }

    public static void main(String[] args) throws Exception {
        printSection("Config loading");
        //TODO: Config.load(); //Конфиги вообще нужны ?

        gameStarter = new GameStarter();
    }

    public static void printSection(String s) {
        s = "=[ " + s + " ]";
        while (s.length() < 61) {
            s = "-" + s;
        }
        LOG.info(s);
    }
}
