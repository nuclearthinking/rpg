package com.nuclearthinking.game.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

/**
 * Created by kuksin-mv on 26.01.2016.
 */
public class MenuBarController
{
    @FXML
    public MenuItem close, about;

    @FXML
    private void initialize()
    {
        close.setOnAction(e ->
        {
            System.exit(0);
        });

        about.setOnAction(event ->
        {
            //TODO: А я хз как попап делать
        });
    }
}
