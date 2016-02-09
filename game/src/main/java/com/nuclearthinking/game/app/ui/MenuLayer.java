package com.nuclearthinking.game.app.ui;

import com.nuclearthinking.game.app.ui.menu.MenuBox;
import com.nuclearthinking.game.app.ui.menu.MenuItem;
import com.nuclearthinking.game.app.ui.menu.SubMenu;
import javafx.scene.layout.Pane;

/**
 * Created by kuksin-mv on 09.02.2016.
 */
public class MenuLayer extends Pane
{
    public static MenuBox menuBox;

    public MenuLayer()
    {
        createMenu();
    }

    private void createMenu()
    {
        MenuItem newGame = new MenuItem("NEW GAME");
        MenuItem option = new MenuItem("OPTION");
        MenuItem exit = new MenuItem("EXIT");

        SubMenu mainMenu = new SubMenu(newGame, option, exit);

        exit.setOnMouseClicked(event -> System.exit(0));

        menuBox = new MenuBox(mainMenu);

        getChildren().add(menuBox);
    }
}
