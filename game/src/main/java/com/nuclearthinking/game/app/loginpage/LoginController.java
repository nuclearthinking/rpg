package com.nuclearthinking.game.app.loginpage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


/**
 * Created by kuksin-mv on 26.01.2016.
 */
public class LoginController
{
    @FXML
    private Button login, exit;

    @FXML
    private TextField loginTxt;

    @FXML
    private Label msgLogin;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private Label msgPassword;

    @FXML
    private void initialize()
    {
        login.setOnAction((event -> {
            String loginTextTmp = loginTxt.getText();
            String passwordTextTmp = passwordTxt.getText();
            if (isValid(loginTextTmp) && isValid(passwordTextTmp))
            {
                System.out.println("Login: " + loginTextTmp);
                System.out.println("Password: " + passwordTextTmp);

                loginTxt.clear();
                passwordTxt.clear();

                msgLogin.setTextFill(null);
                msgPassword.setTextFill(null);
            }
            else if(!isValid(loginTextTmp) && isValid(passwordTextTmp))
            {
                msgLogin.setText("Fill Login");
                msgLogin.setTextFill(Color.RED);

                msgPassword.setTextFill(null);
            }
            else if(isValid(loginTextTmp) && !isValid(passwordTextTmp))
            {
                msgPassword.setText("Fill Password");
                msgPassword.setTextFill(Color.RED);

                msgLogin.setTextFill(null);
            }
            else
            {
                msgLogin.setText("Fill Login");
                msgLogin.setTextFill(Color.RED);
                msgPassword.setText("Fill Password");
                msgPassword.setTextFill(Color.RED);
            }
        }));

        exit.setOnAction((event -> {
            System.out.println("Exit");
            System.exit(0);
        }));

    }

    private boolean isValid(String value)
    {
        if (value.isEmpty() || value.length() <= 0 || value == null )
        {
            return false;
        }
        return true;
    }
}
