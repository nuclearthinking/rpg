package com.nuclearthinking.game.obj.world;

import com.nuclearthinking.game.utils.WorldGenerateUtil;

/**
 * Date: 28.12.2015
 * Time: 15:44
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class Room extends Floor {
    private WorldGenerateUtil worldGenerateUtil = new WorldGenerateUtil();
    private Room roomType;
    private int roomId;


    public Room getRoomType() {
        return roomType;
    }

    public void setRoomType(Room roomType) {
        this.roomType = roomType;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    protected Room generateRoom() {
        Room room = new Room();
        room.setRoomType(worldGenerateUtil.getRandomRoom());
        return room;
    }


}
