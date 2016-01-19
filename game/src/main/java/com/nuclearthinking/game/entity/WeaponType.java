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
}
