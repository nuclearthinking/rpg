package com.nuclearthinking.game.legacy;

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


        /**
         * первое значение при объявлении массива это высота
         * второе значение это ширина
         */
        int[][] initialArray = new int[8][6];
        for (int i = 0; i < initialArray.length; i++) {
            for (int o = 0; o < initialArray[0].length; o++) {
                initialArray[i][o] = 0;
            }
        }

        /**
         * newLevels[0].lenght возвращает размер массива в ширину
         * newLevels.lenght возвращает размер массива в высоту
         */
        System.out.println(initialArray[0].length);
        System.out.println(initialArray.length);
        System.out.println(Arrays.deepToString(initialArray));

    }

    public static int[][] setLabyrint(int[][] array) {

        return null;
    }
}
