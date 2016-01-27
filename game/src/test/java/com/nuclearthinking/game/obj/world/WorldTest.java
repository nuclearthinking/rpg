package com.nuclearthinking.game.obj.world;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Date: 03.01.2016
 * Time: 21:38
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class WorldTest {

    private World world;

    @BeforeMethod
    private void setUp() {
        world = new World();
    }

    @Test
    public void testCreateWorldException() throws Exception {
        try {
            world.createWorld();
        } catch (RuntimeException e) {
            Assert.assertEquals(e.getMessage(), "Размер мира не установлен");
        }

    }

    @Test
    public void testCreateWorldCorrect() {
        world.setSize(30);
        world.createWorld();
        Assert.assertEquals(world.getWorldArray().size(), 30);
    }

    @Test
    public void testGetWorldArrayNull() throws Exception {
        Assert.assertEquals(world.getWorldArray(), null);
    }


    @Test
    public void testGetWorldArraySmall() {
        world.setSize(5);
        world.createWorld();
        Assert.assertEquals(world.getWorldArray().size(), 5);
    }

    @Test
    public void testSetSize() throws Exception {
        world.setSize(15);
        Assert.assertEquals(world.size, 15);
    }

    @Test
    public void testGetRoomById() {
        world.setSize(30);
        world.createWorld();
        Assert.assertEquals(world.getFloorById(1).getFloorId(), 1);
    }

    @Test
    public void testGetRoomByIdTooSmall() {
        world.setSize(13).createWorld();
        String message = null;
        try {
            world.getFloorById(0);
        } catch (RuntimeException e) {
            message = e.getMessage();
        }
        Assert.assertEquals(message, "Несуществующий Floor ID");
    }

    @Test
    public void testGetRoomByIdToLarge() {
        world.setSize(14).createWorld();
        String message = null;
        try {
            world.getFloorById(22);
        } catch (RuntimeException e) {
            message = e.getMessage();
        }
        Assert.assertEquals(message, "Несуществующий Floor ID");
    }
}