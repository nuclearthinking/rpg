package com.nuclearthinking.game.app.controller;

import com.nuclearthinking.game.app.StartApp;
import com.nuclearthinking.game.utils.ResourceUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

/**
 * Created by kuksin-mv on 26.01.2016.
 */
public class MenuBarController
{
    private static ResourceUtil resourceUtil = new ResourceUtil();
    private StartApp startApp = new StartApp();
    private static Stage aboutStage;

    @FXML
    public MenuItem close, about;

    @FXML
    private void initialize()
    {
        close.setOnAction(e -> System.exit(0));

        about.setOnAction(event -> display(startApp.getBundle()));
    }

    public static void display(ResourceBundle bundle)
    {

        try(InputStream is = resourceUtil.getResourceAsStream("fxml\\about.fxml"))
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setResources(bundle);
            GridPane aboutPane = (GridPane) loader.load(is);

            aboutStage = new Stage();
            Scene scene = new Scene(aboutPane);
            aboutStage.initModality(Modality.APPLICATION_MODAL);
            aboutStage.setResizable(false);
            aboutStage.setScene(scene);
            aboutStage.setTitle(bundle.getString("about.title"));
            aboutStage.showAndWait();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Stage getAboutStage()
    {
        return aboutStage;
    }
}
