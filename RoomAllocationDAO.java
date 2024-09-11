package com.hms.Dao;

import com.hms.VegFood;
import java.util.List;

public interface RoomAllocationDAO {
    void saveRoomAllocation(VegFood vegFood);
    VegFood getRoomAllocationById(String bookingId);
    List<VegFood> getAllRoomAllocations();
    void updateRoomAllocation(VegFood vegFood);
    void deleteRoomAllocation(String bookingId);
}