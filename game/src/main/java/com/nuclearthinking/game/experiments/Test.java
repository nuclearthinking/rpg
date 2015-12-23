package com.nuclearthinking.game.experiments;

/**
 * Created
 * Date: 23.12.2015
 * Time: 18:33
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class Test {

    public static void main(String[] args) {
        long startexp = 130;
        int level = 1;
        long expnextlvl = 0;
        long currentex = 0;

        for (int o = 0; o < 60; o++) {
            expnextlvl = level*100-100;
            System.out.println(expnextlvl);
            level++;
        }
    }
}
