package com.hms.Dao;


import java.util.List;
import java.util.Optional;

import com.hms.BookingRoom;

public interface BookingRoomDao {
	BookingRoom save(BookingRoom bookingRoom);
    Optional<BookingRoom> findById(Long bookingId);
    void update(BookingRoom bookingRoom);
    void delete(Long bookingId);
	List<BookingRoom> get();
}
