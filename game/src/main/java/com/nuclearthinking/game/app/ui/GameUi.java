package com.nuclearthinking.game.app.ui;

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
    private static Text text = new Text();

    public void drawStyleString(String msg, double x, double y)
    {
        if(msg == null || msg.length() == 0)
            return;

        text.setStroke(Color.BLACK);
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        text.setText(msg);
        text.setX(x);
        text.setY(y);

        //TODO:Сделать метод для апдейта иначе эта хрени будет сыпать ошибками
        getChildren().add(text);
    }
}
