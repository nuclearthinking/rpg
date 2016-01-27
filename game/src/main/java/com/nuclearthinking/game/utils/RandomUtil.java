package com.nuclearthinking.game.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Date: 28.12.2015
 * Time: 16:25
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class RandomUtil {

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
