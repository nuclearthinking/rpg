package com.nuclearthinking.game.obj.world;

import com.nuclearthinking.game.utils.RandomUtil;

import java.util.Arrays;

/**
 * Date: 28.12.2015
 * Time: 16:52
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class test {


    //Тест алгоритма генерации уровня
    public static void main(String[] args) {

        //создаем двумерный масив нулей
        int[][] levels = new int[8][8];
        for (int i = 0; i < levels.length; i++) {
            for (int o = 0; o < levels.length; o++) {
                levels[i][o] = 0;
            }
        }

        //ставим стартовую точку
        levels[0][1] = 1;


        //пытаемся строить точки от стартовой и до конца в рандомном направлении
        int[][] newLevels = new int[8][8];
        for (int i = 0; i < newLevels.length; i++) {
            for (int o = 0; o < newLevels.length; o++) {
                if (newLevels[i][o] == 1) {
                    if (new RandomUtil().randomInt(1, 2) == 1) {
                        if (o + 1 == newLevels.length) {
                            newLevels[i + 1][o] = 1;
                        } else {
                            newLevels[i][o + 1] = 1;
                        }
                    } else {
                        if (i + 1 == newLevels.length) {
                            newLevels[i][o + 1] = 1;
                        } else {
                            newLevels[i + 1][o] = 1;
                        }
                    }
                }
            }
        }

        // чет не вышло пока
        System.out.println(Arrays.deepToString(levels));
        System.out.println(Arrays.deepToString(newLevels));
    }
}
