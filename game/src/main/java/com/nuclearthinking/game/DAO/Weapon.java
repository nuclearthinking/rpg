package com.nuclearthinking.game.DAO;

import com.nuclearthinking.game.engines.DatabaseEngine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Date: 19.01.2016
 * Time: 18:03
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class Weapon extends DAO {

    private int id;
    private String name;
    private String weaponType;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int damageMinimal;
    private int damageMaximal;


    public Weapon() {
    }

    public Weapon getWeaponFromDbById(int id) {
        checkId(id);
        Weapon weaponFromDb = new Weapon();
        try {
            PreparedStatement preparedStatement = getPreparedStatement();
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                weaponFromDb.setId(rs.getInt(1));
                weaponFromDb.setName(rs.getString(2));
                weaponFromDb.setDamageMinimal(rs.getInt(3));
                weaponFromDb.setDamageMaximal(rs.getInt(4));
                weaponFromDb.setStrengthBonus(rs.getInt(5));
                weaponFromDb.setAgilityBonus(rs.getInt(6));
                weaponFromDb.setIntelligenceBonus(rs.getInt(7));
                weaponFromDb.setWeaponType(new WeaponType().getWeaponTypeNameById(rs.getInt(8)));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weaponFromDb;
    }

    @Override
    PreparedStatement getPreparedStatement() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseEngine.getInstance().getConnection().prepareStatement("SELECT * FROM weapon WHERE weapon_id = ?;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    public int getAgilityBonus() {
        return agilityBonus;
    }

    public void setAgilityBonus(int agilityBonus) {
        this.agilityBonus = agilityBonus;
    }

    public int getIntelligenceBonus() {
        return intelligenceBonus;
    }

    public void setIntelligenceBonus(int intelligenceBonus) {
        this.intelligenceBonus = intelligenceBonus;
    }

    public int getDamageMinimal() {
        return damageMinimal;
    }

    public void setDamageMinimal(int damageMinimal) {
        this.damageMinimal = damageMinimal;
    }

    public int getDamageMaximal() {
        return damageMaximal;
    }

    public void setDamageMaximal(int damageMaximal) {
        this.damageMaximal = damageMaximal;
    }
}
