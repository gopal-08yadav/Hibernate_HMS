package com.hms.Dao;

import java.util.List;

import com.hms.Room;

public interface RoomDao {
    Room getRoomByNumber(Long room_id);
    Room saveRoom(Room room);
    Room updateRoom(Long room_id,Room room);
    void deleteRoom(Long room_id);
	List<Room> getAllRooms();
	
}
