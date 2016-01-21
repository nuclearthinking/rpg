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
public class WeaponType {
    @Id
    @GeneratedValue
    private Integer weaponTypeId;
    private String weaponTypeName;

    public WeaponType() {
    }

    public String getWeaponTypeName() {
        return weaponTypeName;
    }

    public void setWeaponTypeName(String weaponTypeName) {
        this.weaponTypeName = weaponTypeName;
    }

    public Integer getWeaponTypeId() {

        return weaponTypeId;
    }

    public void setWeaponTypeId(Integer weaponTypeId) {
        this.weaponTypeId = weaponTypeId;
    }
}
