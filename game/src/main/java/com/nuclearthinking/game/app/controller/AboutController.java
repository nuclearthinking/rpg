package com.nuclearthinking.game.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by kuksin-mv on 28.01.2016.
 */
public class AboutController
{
    @FXML
    private Button okButton;

    @FXML
    private void initialize()
    {
        okButton.setOnAction(event -> MenuBarController.getAboutStage().close());
    }
}
