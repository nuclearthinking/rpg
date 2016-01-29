package com.nuclearthinking.game.app.controller;

import com.nuclearthinking.game.engines.PreparePlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

/**
 * Created by kuksin-mv on 28.01.2016.
 */
public class CreateCharacterController
{
    @FXML
    private TextField playerName;

    @FXML
    private ChoiceBox selectClass;

    @FXML
    private Button create;

    @FXML
    private void initialize()
    {
        playerName.setTooltip(new Tooltip("Fill Player Name"));

        selectClass.setTooltip(new Tooltip("Select the Class"));
        selectClass.getItems().addAll("Mag", "Warrior", "Rogue");
        selectClass.getSelectionModel().selectFirst();

        create.setOnAction(event ->
        {
            new PreparePlayer(playerName.getText(),(String)selectClass.getSelectionModel().getSelectedItem()).getPlayer();
        });
    }
}
