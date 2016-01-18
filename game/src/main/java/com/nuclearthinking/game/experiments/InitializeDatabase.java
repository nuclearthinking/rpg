package com.nuclearthinking.game.experiments;

import org.h2.tools.DeleteDbFiles;

import java.sql.*;

/**
 * Date: 14.01.2016
 * Time: 15:27
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */


public class InitializeDatabase {
    public static void main(String... args) throws Exception {
        // delete the database named 'test' in the user home directory
        DeleteDbFiles.execute("~", "test", true);

        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test","admin","admin");
        Statement stat = conn.createStatement();

        // this line would initialize the database
        // from the SQL script file 'init.sql'
        // stat.execute("runscript from 'init.sql'");

        stat.execute("create table test(id int primary key, name varchar(255))");
        stat.execute("insert into test values(1, 'Hello')");
        ResultSet rs;
        rs = stat.executeQuery("select * from test");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        stat.close();
        conn.close();
    }
}
