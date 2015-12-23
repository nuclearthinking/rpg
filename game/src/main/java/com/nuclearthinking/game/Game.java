package com.nuclearthinking.game;

import com.nuclearthinking.game.obj.Player;
import com.nuclearthinking.game.utils.UserInput;

/**
 * Created
 * Date: 23.12.2015
 * Time: 14:21
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class Game {

    private Game() {
        Player player = Player.getInstance();
        setName(player);
    }

    private static class GameHodler {
        private static final Game INSTANCE = new Game();
    }

    public static Game getInstance() {
        return GameHodler.INSTANCE;
    }


    private void setName(Player player) {
        if (player.getName() == null) {
            System.out.println("Введите имя персонажа");
            UserInput input = new UserInput();
            player.setName(input.getUserInput());
            System.out.println("Добро пожаловать " + player.getName());
        }
    }

}
