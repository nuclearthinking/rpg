package com.nuclearthinking.game.app.ui.menu;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by kuksin-mv on 09.02.2016.
 */
public class MenuBox extends Pane
{
    static SubMenu subMenu;

    public MenuBox(SubMenu subMenu)
    {
        MenuBox.subMenu = subMenu;

        setVisible(false);

        Rectangle bg = new Rectangle(900, 600, Color.AQUA);
        bg.setOpacity(0.4);
        getChildren().addAll(bg, subMenu);
    }

    public void setMenu(SubMenu subMenu)
    {
        getChildren().remove(MenuBox.subMenu);
        MenuBox.subMenu = subMenu;
        getChildren().add(MenuBox.subMenu);
    }
}
