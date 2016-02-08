package com.nuclearthinking.game.app.ui;

import com.nuclearthinking.game.app.utils.ManagerResources;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by Izonami on 08.02.2016.
 */
public class GameUi extends Pane
{
    private final Image HOT_BAR = ManagerResources.loadImage("img\\hotbar.png");
    private final ImageView imageView = new ImageView(HOT_BAR);

    private static Text text = new Text();

    public GameUi()
    {
        drawPlayerUi();
    }

    private void drawPlayerUi()
    {
        //TODO: Это должно как то зависеть от камеры
        imageView.setX(10);
        imageView.setY(800);
        getChildren().add(imageView);
    }

    public void drawPlayerName(String msg)
    {
        if(msg == null || msg.length() == 0)
            return;

        text.setStroke(Color.BLACK);
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        text.setText(msg);

        getChildren().add(text);
    }

    public void updateNamePos(double x, double y)
    {
        text.setX(text.getText().length() > 6 ? x : x + 20);
        text.setY(y);
    }
}
