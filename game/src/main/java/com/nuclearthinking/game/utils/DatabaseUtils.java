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


    public void initDb() {
        try {
            ResourceUtil ru = new ResourceUtil();

            Class.forName("org.h2.Driver");
            InputStream in = ru.getResourceAsStream("sql/create.sql");
            if (in == null) {
                System.out.println("Please add the file script.sql to the classpath, package "
                        + getClass().getPackage().getName());
            } else {
                Connection conn = DriverManager.getConnection("jdbc:h2:mem:game;MODE=MySQL", "admin", "admin");
                RunScript.execute(conn, new InputStreamReader(in));
                conn.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
