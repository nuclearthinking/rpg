package com.nuclearthinking.game.app.ui;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by kuksin-mv on 09.02.2016.
 */
public class SystemLayer extends Pane
{
    private static Text text = new Text();

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
