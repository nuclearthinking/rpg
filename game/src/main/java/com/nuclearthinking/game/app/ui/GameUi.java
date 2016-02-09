package com.nuclearthinking.game.app.ui;

import com.nuclearthinking.game.app.ui.menu.MenuBox;
import com.nuclearthinking.game.app.utils.ManagerResources;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by Izonami on 08.02.2016.
 */
public class GameUi extends Pane
{
    private final Image HOT_BAR = ManagerResources.loadImage("img\\hotbar.png");
    private final ImageView imageView = new ImageView(HOT_BAR);

    public static MenuBox menuBox;

    public GameUi()
    {
       // drawPlayerUi();
    }

    private void drawPlayerUi()
    {
        //TODO: Это должно как то зависеть от камеры
        imageView.setX(10);
        imageView.setY(800);
        getChildren().add(imageView);
    }
}
