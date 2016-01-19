package com.nuclearthinking.game.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Date: 19.01.2016
 * Time: 18:03
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

@Entity
public class Weapon {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer weaponType;
    private Integer strenghtBonus;
    private Integer agilityBonus;
    private Integer intelligenceBonus;
    private Integer damageMinimal;
    private Integer damageMaximal;
}
