package com.nuclearthinking.game.DAO;

import com.nuclearthinking.game.engines.DatabaseEngine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Date: 19.01.2016
 * Time: 18:03
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

@Entity
public class Armor {
    private Connection connection;

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer armorType;
    private Integer strengthBonus;
    private Integer agilityBonus;
    private Integer intelligenceBonus;

    public Armor(){
    }
    public Armor(Connection conn) {
        this.connection = conn;
    }

    public Armor getArmorByID(int id) {
        Armor armorFromDB = new Armor();
        try {
        ResultSet rs = new DatabaseEngine().executeQuery("SELECT * FROM armor WHERE armor_id = "+id+";",connection);
            armorFromDB.setId(rs.getInt(1));
            armorFromDB.setName(rs.getString(2));
            armorFromDB.setStrengthBonus(3);
            armorFromDB.setIntelligenceBonus(4);
            armorFromDB.setAgilityBonus(5);
            armorFromDB.setArmorAmount(6);
            armorFromDB.setArmorType(7);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armorFromDB;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArmorType() {
        return armorType;
    }

    public void setArmorType(Integer armorType) {
        this.armorType = armorType;
    }

    public Integer getStrengthBonus() {
        return strengthBonus;
    }

    public void setStrengthBonus(Integer strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    public Integer getAgilityBonus() {
        return agilityBonus;
    }

    public void setAgilityBonus(Integer agilityBonus) {
        this.agilityBonus = agilityBonus;
    }

    public Integer getIntelligenceBonus() {
        return intelligenceBonus;
    }

    public void setIntelligenceBonus(Integer intelligenceBonus) {
        this.intelligenceBonus = intelligenceBonus;
    }

    public Integer getArmorAmount() {
        return armorAmount;
    }

    public void setArmorAmount(Integer armorAmount) {
        this.armorAmount = armorAmount;
    }

    private Integer armorAmount;
}
