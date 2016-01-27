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

public class ArmorType extends DAO {

    private Integer armorTypeId;
    private String armorTypeName;

    public ArmorType() {
    }

    public ArmorType getArmorTypeById(int id) {
        checkId(id);
        ArmorType armorTypeFromDb = new ArmorType();
        try {
            PreparedStatement preparedStatement = getPreparedStatement();
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                armorTypeFromDb.setArmorTypeId(rs.getInt(1));
                armorTypeFromDb.setArmorTypeName(rs.getString(2));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armorTypeFromDb;
    }

    public String getArmorTypeNameById(int id) {
        checkId(id);
        String armorTypeName = null;
        try {
            PreparedStatement preparedStatement = getPreparedStatement();
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                armorTypeName = rs.getString(2);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armorTypeName;
    }


    @Override
    PreparedStatement getPreparedStatement() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseEngine.getInstance().getConnection().prepareStatement("SELECT * FROM armor_types WHERE armor_type_id = ?;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public Integer getArmorTypeId() {
        return armorTypeId;
    }

    public void setArmorTypeId(Integer armorTypeId) {
        this.armorTypeId = armorTypeId;
    }

    public String getArmorTypeName() {
        return armorTypeName;
    }

    public void setArmorTypeName(String armorTypeName) {
        this.armorTypeName = armorTypeName;
    }
}
