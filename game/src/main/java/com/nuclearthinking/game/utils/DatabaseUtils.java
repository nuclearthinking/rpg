package com.nuclearthinking.game.utils;

import org.h2.tools.RunScript;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Date: 20.01.2016
 * Time: 18:13
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class DatabaseUtils {
    private static final String H2_DB_URL = "jdbc:h2:mem:game;MODE=MySQL";

    public void initDb() {
        try {
            ResourceUtil ru = new ResourceUtil();

            Class.forName("org.h2.Driver");
            InputStream in = ru.getResourceAsStream("sql/create.sql");
            if (in == null) {
                System.out.println("Please add the file create.sql to the classpath, package "
                        + getClass().getPackage().getName());
            } else {
                Connection conn = DriverManager.getConnection(H2_DB_URL, "admin", "admin");
                RunScript.execute(conn, new InputStreamReader(in));
                conn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(H2_DB_URL, "admin", "admin");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        if (conn != null) {
            return conn;
        } else {
            throw new RuntimeException("Не удалось создать подключение");
        }
    }

}
