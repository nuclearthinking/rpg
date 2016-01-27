package com.nuclearthinking.game.obj.world;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Date: 05.01.2016
 * Time: 0:31
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class FloorTest {
    private Floor floor;

    @BeforeMethod
    public void setUp() {
        floor = new Floor();
    }

    @Test
    public void testGenerateFloor() throws Exception {
        Floor floorGenerated = floor.generateFloor();
        Assert.assertNotNull(floorGenerated.getFloorMap().length);
    }

    @Test
    public void testGetRoomById() throws Exception {
        Floor generatedFloor = floor.generateFloor();
        Assert.assertEquals(generatedFloor.getRoomById(1).getRoomId(), 1);
    }
}