package com.nuclearthinking.game.app.controller;

import com.nuclearthinking.game.app.StartApp;
import com.nuclearthinking.game.engines.PreparePlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * Created by kuksin-mv on 28.01.2016.
 */
public class CreateCharacterController
{
    private static final StartApp startApp = new StartApp();

    @FXML
    private TextField playerName;

    @FXML
    private ChoiceBox selectClass;

    @FXML
    private Button create, back;

    @FXML
    private void initialize()
    {
        selectClass.getItems().addAll("Mag", "Warrior", "Rogue");
        selectClass.getSelectionModel().selectFirst();

        create.setOnAction(event ->
        {
            new PreparePlayer(playerName.getText(), (String) selectClass.getSelectionModel().getSelectedItem()).getPlayer();
        });

        back.setOnAction(event -> startApp.loadOverview(startApp.getBundle(), "fxml\\auth.fxml"));
    }
}
