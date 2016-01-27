package com.nuclearthinking.game.DAO;

import com.nuclearthinking.game.engines.DatabaseEngine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Date: 19.01.2016
 * Time: 18:12
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class WeaponType extends DAO {
    private int weaponTypeId;
    private String weaponTypeName;

    public WeaponType() {
    }

    public WeaponType getWeaponTypeById(int id) {
        checkId(id);
        WeaponType weaponTypeFromDb = new WeaponType();
        try {
            PreparedStatement preparedStatement = DatabaseEngine.getInstance().getConnection().prepareStatement("SELECT * FROM weapon_types WHERE weapon_type_id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                weaponTypeFromDb.setWeaponTypeId(rs.getInt(1));
                weaponTypeFromDb.setWeaponTypeName(rs.getString(2));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weaponTypeFromDb;
    }

    public String getWeaponTypeNameById(int id) {
        checkId(id);
        String weaponTypeName = null;
        try {
            PreparedStatement preparedStatement = getPreparedStatement();
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                weaponTypeName = rs.getString(2);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weaponTypeName;
    }

    @Override
    PreparedStatement getPreparedStatement() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseEngine.getInstance().getConnection().prepareStatement("SELECT * FROM weapon_types WHERE weapon_type_id = ?;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
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
