package com.nuclearthinking.game.DAO;

import com.nuclearthinking.game.engines.DatabaseEngine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Date: 19.01.2016
 * Time: 18:12
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

@Entity
public class WeaponType {
    @Id
    @GeneratedValue
    private int weaponTypeId;
    private String weaponTypeName;

    public WeaponType() {
    }

    public WeaponType getWeaponTypeById(int id) {
        WeaponType weaponTypeFromDb = new WeaponType();
        try {
            ResultSet rs = DatabaseEngine.getInstance().executeQuery("SELECT * FROM weapon_types WHERE weapon_type_id = " + id + ";");
            if (rs.next()) {
                weaponTypeFromDb.setWeaponTypeId(rs.getInt(1));
                weaponTypeFromDb.setWeaponTypeName(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weaponTypeFromDb;
    }

    public String getWeaponTypeNameById(int id) {
        String weaponTypeName = null;
        try {
            ResultSet rs = DatabaseEngine.getInstance().executeQuery("SELECT * FROM weapon_types WHERE weapon_type_id = " + id + ";");
            if (rs.next()) {
                weaponTypeName = rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weaponTypeName;
    }

    public String getWeaponTypeName() {
        return weaponTypeName;
    }

    public void setWeaponTypeName(String weaponTypeName) {
        this.weaponTypeName = weaponTypeName;
    }

    public int getWeaponTypeId() {

        return weaponTypeId;
    }

    public void setWeaponTypeId(int weaponTypeId) {
        this.weaponTypeId = weaponTypeId;
    }
}
