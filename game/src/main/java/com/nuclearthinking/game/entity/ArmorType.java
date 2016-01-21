package com.nuclearthinking.game.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
