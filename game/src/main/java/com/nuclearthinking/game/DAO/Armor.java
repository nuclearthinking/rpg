package com.nuclearthinking.game.DAO;

import com.nuclearthinking.game.engines.DatabaseEngine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Date: 19.01.2016
 * Time: 18:03
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

@Entity
public class Armor {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String armorType;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;

    public Armor() {
    }

    public Armor getArmorByID(int id) {
        Armor armorFromDB = new Armor();
        try {
            ResultSet rs = DatabaseEngine.getInstance().executeQuery("SELECT * FROM armor WHERE armor_id = " + id + ";");
            if (rs.next()) {
                armorFromDB.setId(rs.getInt(1));
                armorFromDB.setName(rs.getString(2));
                armorFromDB.setStrengthBonus(rs.getInt(3));
                armorFromDB.setIntelligenceBonus(rs.getInt(4));
                armorFromDB.setAgilityBonus(rs.getInt(5));
                armorFromDB.setArmorAmount(rs.getInt(6));
                armorFromDB.setArmorType(new ArmorType().getArmorTypeNameById(rs.getInt(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armorFromDB;
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

    private int armorAmount;
}
