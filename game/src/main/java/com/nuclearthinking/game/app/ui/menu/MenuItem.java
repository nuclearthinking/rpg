package com.nuclearthinking.game.app.ui.menu;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Created by kuksin-mv on 09.02.2016.
 */
public class MenuItem extends StackPane
{
    public MenuItem(String name)
    {
        Rectangle bg = new Rectangle(200, 20, Color.WHITE);
        bg.setOpacity(0.5);

        Text text = new Text(name);
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        setAlignment(Pos.CENTER);
        getChildren().addAll(bg, text);

        FillTransition ft = new FillTransition(Duration.seconds(0.5), bg);
        setOnMouseEntered(event ->
        {
            ft.setFromValue(Color.DARKGREY);
            ft.setToValue(Color.DARKORANGE);
            ft.setCycleCount(Animation.INDEFINITE);
            ft.setAutoReverse(true); //Разварот анимации от setFromValue до setToValue и от setToValue до setFromValue
            ft.play();
        });

        setOnMouseExited(event ->
        {
            ft.stop();
            bg.setFill(Color.WHITE);
        });
    }
}
