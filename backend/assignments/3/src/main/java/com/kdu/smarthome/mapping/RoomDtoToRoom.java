package com.kdu.smartHome.mapping;

import com.kdu.smartHome.dto.RoomRequestDTO;
import com.kdu.smartHome.model.Rooms;

public class RoomDtoToRoom {
    public static Rooms roomDtoToRoom(RoomRequestDTO room)
    {
        Rooms rooms=new Rooms();
        rooms.setRoomName(room.getRoomName());
        return rooms;
    }
}
