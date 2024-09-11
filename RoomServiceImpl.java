package com.hms.serviceImp;

import java.util.List;

import com.hms.Room;
import com.hms.Dao.RoomDao;
import com.hms.DaoImp.RoomDaoImpl;
import Services.RoomService;

public class RoomServiceImpl implements RoomService {

    private RoomDao roomDao = new RoomDaoImpl();

    @Override
    public Room getRoomByNumber(Long room_id) {
        return roomDao.getRoomByNumber(room_id);
    }

    @Override
    public Room createRoom(Room room) {
        roomDao.saveRoom(room);
        
		return room;
    }

    @Override
    public Room updateRoom(Long room_id,Room room) {
        roomDao.updateRoom(room_id,room);
        
		return room;
    }

    @Override
    public void deleteRoom(Long room_id) {
        roomDao.deleteRoom(room_id);
		
    }

	@Override
	public Room addRoom(Room room) {
		//roomDao.addRoom(roomNumber);
		return room;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Room> getAllRooms() {
		// TODO Auto-generated method stub
		return  roomDao.getAllRooms();
	}

}
