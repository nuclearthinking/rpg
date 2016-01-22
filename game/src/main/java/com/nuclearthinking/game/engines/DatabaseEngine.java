package com.nuclearthinking.game.engines;

import com.nuclearthinking.game.utils.ResourceUtil;
import org.h2.tools.RunScript;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Date: 21.01.2016
 * Time: 18:45
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class DatabaseEngine {


//    private static final String H2_DB_URL = "jdbc:h2:mem:game;MODE=MySQL";
        private static final String H2_DB_URL = "jdbc:h2:file:./src/main/resources/sql/game;MODE=MySQL";
    private Connection connection;

    public DatabaseEngine() {

    }

    public DatabaseEngine initDb() {
        try {
            ResourceUtil ru = new ResourceUtil();
            Class.forName("org.h2.Driver");
            InputStream in = ru.getResourceAsStream("sql/create.sql");
            InputStream in2 = ru.getResourceAsStream("sql/fill.sql");
            if (in == null) {
                System.out.println("Please add the file create.sql to the classpath, package "
                        + getClass().getPackage().getName());
            } else {
                this.connection = DriverManager.getConnection(H2_DB_URL, "admin", "admin");
                RunScript.execute(connection, new InputStreamReader(in));
                RunScript.execute(connection, new InputStreamReader(in2));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return this;
    }

    public Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            throw new RuntimeException("База данных не инициализована");
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new RuntimeException("Соединение не открыто");
        }
    }

    public ResultSet executeQuery(String SQLquerry,Connection connection) {
        if (connection == null) throw new RuntimeException("База данных не инициализированна");
        ResultSet rs = null;
        try {
            Statement stat = connection.createStatement();
            rs = stat.executeQuery(SQLquerry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


}
