package com.nuclearthinking.game.experiments;

import com.nuclearthinking.game.utils.ResourceUtil;
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
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:game;MODE=MySQL", "admin", "admin");
        Statement stat = conn.createStatement();
        stat.execute("CREATE SCHEMA IF NOT EXISTS `game`;");
        stat.execute("USE `game`;");
        stat.execute("CREATE TABLE IF NOT EXISTS `game`.`weapon_types` ( `weapon_type_id` INT NOT NULL AUTO_INCREMENT,`weapon_type_name` VARCHAR(45) NULL,PRIMARY KEY (`weapon_type_id`))ENGINE = InnoDB;");
        stat.execute("CREATE TABLE IF NOT EXISTS `game`.`weapon` ( `weapon_id` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(45) NOT NULL, `damage_minimal` INT NOT NULL, `damage_maximal` INT NOT NULL, `str_b` INT NULL, `agi_b` INT NULL, `int_b` INT NULL, `weapon_type` INT NULL, PRIMARY KEY (`weapon_id`), INDEX `weapontypedict_idx` (`weapon_type` ASC), CONSTRAINT `weapontypedict` FOREIGN KEY (`weapon_type`) REFERENCES `game`.`weapon_types` (`weapon_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION)  ENGINE = InnoDB;");
        stat.execute("CREATE TABLE IF NOT EXISTS `game`.`armor_types` ( `armor_type_id`   INT         NOT NULL, `armor_type_name` VARCHAR(45) NOT NULL, PRIMARY KEY (`armor_type_id`) ) ENGINE = InnoDB;");
        stat.execute("CREATE TABLE IF NOT EXISTS `game`.`armor` ( `armor_id`     INT         NOT NULL AUTO_INCREMENT, `armor_type`   INT         NULL,  `name`         VARCHAR(45) NULL, `str_b`        INT         NULL,  `int_b`        INT         NULL, `agi_b`        INT         NULL,  `armor_amount` INT         NULL, PRIMARY KEY (`armor_id`), INDEX `armor_idx` (`armor_type` ASC), CONSTRAINT `armor` FOREIGN KEY (`armor_type`) REFERENCES `game`.`armor_types` (`armor_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION ) ENGINE = InnoDB;");
        stat.execute("SCRIPT TO 'src/main/resources/sql/script.sql'");
        stat.close();
        conn.close();
    }

    /**
     * Initialize a database from a SQL script file.
     */
    void initDb() throws Exception {
        ResourceUtil ru = new ResourceUtil();
        Class.forName("org.h2.Driver");
        InputStream in = ru.getResourceAsStream("sql/init.sql");
        ru = null;
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
