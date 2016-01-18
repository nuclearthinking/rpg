package com.nuclearthinking.game.experiments;

import org.h2.store.fs.FileUtils;
import org.h2.tools.Backup;
import org.h2.tools.DeleteDbFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Date: 18.01.2016
 * Time: 18:34
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class ReadOnlyDatabaseInZip {

    /**
     * This method is called when executing this sample application from the
     * command line.
     *
     * @param args the command line parameters
     */
    public static void main(String... args) throws Exception {

        // delete all files in this directory
        FileUtils.deleteRecursive("~/temp", false);

        Connection conn;
        Class.forName("org.h2.Driver");

        // create a database where the database file is split into
        // multiple small files, 4 MB each (2^22). The larger the
        // parts, the faster opening the database, but also the
        // more files. 4 MB seems to be a good compromise, so
        // the prefix split:22: is used, which means each part is
        // 2^22 bytes long
        conn = DriverManager.getConnection(
                "jdbc:h2:split:22:~/temp/test");

        System.out.println("adding test data...");
        Statement stat = conn.createStatement();
        stat.execute(
                "create table test(id int primary key, name varchar) " +
                        "as select x, space(1000) from system_range(1, 2000)");

        System.out.println("defrag to reduce random access...");
        stat.execute("shutdown defrag");
        conn.close();

        System.out.println("create the zip file...");
        Backup.execute("~/temp/test.zip", "~/temp", "", true);

        // delete the old database files
        DeleteDbFiles.execute("split:~/temp", "test", true);

        System.out.println("open the database from the zip file...");
        conn = DriverManager.getConnection(
                "jdbc:h2:split:zip:~/temp/test.zip!/test");
        // the database can now be used
        conn.close();
    }

}
