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
public class ArmorType {

    @Id
    @GeneratedValue
    private Integer armorTypeId;

    private String armorTypeName;


    public ArmorType() {
    }

    public ArmorType getArmorTypeById(int id) {
        ArmorType armorTypeFromDb = new ArmorType();
        try {
            ResultSet rs = DatabaseEngine.getInstance().executeQuery("SELECT * FROM armor_types WHERE armor_type_id = " + id + ";");
            if (rs.next()) {
                armorTypeFromDb.setArmorTypeId(rs.getInt(1));
                armorTypeFromDb.setArmorTypeName(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armorTypeFromDb;
    }

    public String getArmorTypeNameById(int id) {
        String armorTypeName = null;
        try {
            ResultSet rs = DatabaseEngine.getInstance().executeQuery("SELECT * FROM armor_types WHERE armor_type_id = " + id + ";");
            if (rs.next()) {
                armorTypeName = rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armorTypeName;
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
