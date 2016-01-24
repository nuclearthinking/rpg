package com.nuclearthinking.game.DAO;

import java.sql.PreparedStatement;

/**
 * Created by onifent
 */

public abstract class DAO {


    protected void checkId(int id) {
        if (id <= 0) throw new RuntimeException("Недопустимое значение");
    }

    abstract PreparedStatement getPreparedStatement();
}
