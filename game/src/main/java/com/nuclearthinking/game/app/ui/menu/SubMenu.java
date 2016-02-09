package com.nuclearthinking.game.app.ui.menu;

import javafx.scene.layout.VBox;

/**
 * Created by kuksin-mv on 09.02.2016.
 */
public class SubMenu extends VBox
{
    public SubMenu(MenuItem... items)
    {
        setSpacing(15);
        setTranslateX(50);
        setTranslateY(100);

        for(MenuItem item : items)
        {
            getChildren().addAll(item);
        }
    }
}
