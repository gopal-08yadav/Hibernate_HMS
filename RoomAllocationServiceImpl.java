package com.hms.serviceImp;

import com.hms.VegFood;
import com.hms.Dao.RoomAllocationDAO;
import Services.RoomAllocationService;

import java.util.List;

public class RoomAllocationServiceImpl implements RoomAllocationService {

    private RoomAllocationDAO roomAllocationDAO;

    public RoomAllocationServiceImpl(RoomAllocationDAO roomAllocationDAO) {
        this.roomAllocationDAO = roomAllocationDAO;
    }

    @Override
    public void createRoomAllocation(VegFood vegFood) {
        roomAllocationDAO.saveRoomAllocation(vegFood);
    }

    @Override
    public VegFood findRoomAllocationById(String bookingId) {
        return roomAllocationDAO.getRoomAllocationById(bookingId);
    }

    @Override
    public List<VegFood> findAllRoomAllocations() {
        return roomAllocationDAO.getAllRoomAllocations();
    }

    @Override
    public void modifyRoomAllocation(VegFood vegFood) {
        roomAllocationDAO.updateRoomAllocation(vegFood);
    }

    @Override
    public void removeRoomAllocation(String bookingId) {
        roomAllocationDAO.deleteRoomAllocation(bookingId);
    }
}