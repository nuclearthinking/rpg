package com.nuclearthinking.game.experiments;

import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.obj.world.WorldManager;

/**
 * Date: 21.01.2016
 * Time: 10:38
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class Benchmarking {


    public static void main(String[] args) {

        long time = System.nanoTime();
        System.nanoTime();
        long nanoMistake = System.nanoTime() - time;

        long benchmarkSum = 0;
        for (int i = 0; i < 1000; i++) {
            long timer = System.nanoTime();

            // Вставить код сюда

            World world = new WorldManager(30).getWorld();

            // Вставить код выше

            long timer2 = System.nanoTime();


            benchmarkSum += (timer2 - timer);
        }

        long averageBench = benchmarkSum / 1000;
        System.out.println(averageBench);
    }
}
