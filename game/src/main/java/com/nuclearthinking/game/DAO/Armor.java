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

public class Armor extends DAO {

    private int id;
    private String name;
    private String armorType;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int armorAmount;

    public Armor() {
    }

    public Armor getArmorByID(int id) {
        checkId(id);
        Armor armorFromDB = new Armor();
        try {
            PreparedStatement preparedStatement = getPreparedStatement();
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                armorFromDB.setId(rs.getInt(1));
                armorFromDB.setName(rs.getString(2));
                armorFromDB.setStrengthBonus(rs.getInt(3));
                armorFromDB.setIntelligenceBonus(rs.getInt(4));
                armorFromDB.setAgilityBonus(rs.getInt(5));
                armorFromDB.setArmorAmount(rs.getInt(6));
                armorFromDB.setArmorType(new ArmorType().getArmorTypeNameById(rs.getInt(7)));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armorFromDB;
    }

    @Override
    PreparedStatement getPreparedStatement() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseEngine.getInstance().getConnection().prepareStatement("SELECT * FROM armor WHERE armor_id = ?;");
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

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
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

    public int getArmorAmount() {
        return armorAmount;
    }

    public void setArmorAmount(int armorAmount) {
        this.armorAmount = armorAmount;
    }
}
