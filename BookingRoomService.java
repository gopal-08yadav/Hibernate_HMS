package Services;



import java.util.List;
import com.hms.BookingRoom;

import java.util.Optional;

public interface BookingRoomService {
	BookingRoom createBookingRoom(BookingRoom bookingRoom);
    Optional<BookingRoom> getBookingRoomById(Long bookingId);
    void updateBookingRoom(BookingRoom bookingRoom);
    void deleteBookingRoom(Long bookingId);
	List<BookingRoom> getAllBookingRooms();
}


