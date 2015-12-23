package com.nuclearthinking.game;

import com.nuclearthinking.game.obj.Player;
import com.nuclearthinking.game.utils.UserInput;
import com.nuclearthinking.game.utils.Util;

/**
 * Created
 * Date: 23.12.2015
 * Time: 14:21
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public final class Game {

    private Game() {
        Player player = Player.getInstance();
        setName(player);
    }

    private static class GameHolder {
        private static final Game INSTANCE = new Game();
    }

    public static Game getInstance() {
        return GameHolder.INSTANCE;
    }


    private void setName(Player player) {
        if (player.getName() == null) {
            UserInput input = new UserInput();
            Util ut = new Util();
            boolean valid = false;
            String playerName = null;
            while (!valid){
                System.out.println("Введите имя персонажа");
                playerName = input.getUserInput();
                valid = !ut.isNumericOnly(playerName);
            }
            String playerUpperCaseName = ut.setFirstCharUpperCase(playerName);
            player.setName(playerUpperCaseName);
            System.out.println("Добро пожаловать " + player.getName());
        }
    }

}
