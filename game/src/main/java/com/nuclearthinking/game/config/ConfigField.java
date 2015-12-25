package com.nuclearthinking.game.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Date: 24.12.2015
 * Time: 13:44
 *
 * @author kuksin-mv
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigField {
    String config();

    String fieldName() default "";

    String value() default "";
}
