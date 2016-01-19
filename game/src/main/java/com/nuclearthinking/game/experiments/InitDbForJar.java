package com.nuclearthinking.game.experiments;

import org.h2.tools.DeleteDbFiles;
import org.h2.tools.RunScript;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Date: 18.01.2016
 * Time: 18:21
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class InitDbForJar {
    public static void main(String... args) throws Exception {
        createScript();
//        new InitDbForJar().initDb();
    }

    /**
     * Create a script from a new database.
     */
    private static void createScript() throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:game","admin","admin");
        Statement stat = conn.createStatement();
        stat.execute("CREATE TABLE GAME(NAME VARCHAR)");
        stat.execute("INSERT INTO GAME VALUES('Hello World')");
        stat.execute("SCRIPT TO 'src/main/resources/sql/script.sql'");
        stat.close();
        conn.close();
    }

    /**
     * Initialize a database from a SQL script file.
     */
    void initDb() throws Exception {
        Class.forName("org.h2.Driver");
        InputStream in = getClass().getResourceAsStream("script.sql");
        if (in == null) {
            System.out.println("Please add the file script.sql to the classpath, package "
                    + getClass().getPackage().getName());
        } else {
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
            RunScript.execute(conn, new InputStreamReader(in));
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM TEST");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            rs.close();
            stat.close();
            conn.close();
        }
    }
}
