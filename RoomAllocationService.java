package Services;

import com.hms.VegFood;
import java.util.List;

public interface RoomAllocationService {
    void createRoomAllocation(VegFood vegFood);
    VegFood findRoomAllocationById(String bookingId);
    List<VegFood> findAllRoomAllocations();
    void modifyRoomAllocation(VegFood vegFood);
    void removeRoomAllocation(String bookingId);
}
