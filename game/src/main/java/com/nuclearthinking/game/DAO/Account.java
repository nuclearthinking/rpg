package com.nuclearthinking.game.DAO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by kuksin-mv on 26.01.2016.
 *
 * TODO: Создать таблицу и переделать
 */
public class Account
{
    private final StringProperty login;
    private final StringProperty password;

    public Account()
    {
        this(null, null);
    }

    public Account(String login, String pass)
    {
        this.login = new SimpleStringProperty(login);
        this.password = new SimpleStringProperty(pass);
    }

    public String getLogin()
    {
        return login.get();
    }

    public StringProperty getLoginProperty()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login.set(login);
    }

    public String getPassword()
    {
        return password.get();
    }

    public StringProperty getPasswordProperty()
    {
        return password;
    }

    public void setPassword(String pass)
    {
        this.password.set(pass);
    }
}
