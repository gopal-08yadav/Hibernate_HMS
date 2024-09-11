package Services;


import java.util.List;

import com.hms.Room;

public interface RoomService {
    Room getRoomByNumber(Long room_id);
    Room createRoom(Room room);
    //Room updateRoom(Room room);
    Room updateRoom(Long room_id,Room updatedRoom);
    void deleteRoom(Long room_id);
    Room addRoom(Room room);
	List<Room> getAllRooms();
}
