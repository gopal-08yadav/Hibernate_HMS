package com.hms.serviceImp;

import java.util.List;  
import com.hms.BookingRoom;
import com.hms.Dao.BookingRoomDao;
import com.hms.DaoImp.BookingRoomDaoImpl;


import Services.BookingRoomService;

import java.util.Optional;

public class BookingRoomServiceImpl implements BookingRoomService {

    private BookingRoomDao bookingRoomDAO = new BookingRoomDaoImpl();

    @Override
    public BookingRoom createBookingRoom(BookingRoom bookingRoom) {
        return bookingRoomDAO.save(bookingRoom);
    }

    @Override
    public Optional<BookingRoom> getBookingRoomById(Long bookingId) {
        return bookingRoomDAO.findById(bookingId);
    }

    @Override
    public void updateBookingRoom(BookingRoom bookingRoom) {
        bookingRoomDAO.update(bookingRoom);
    }

    @Override
    public void deleteBookingRoom(Long bookingId) {
        bookingRoomDAO.delete(bookingId);
    }

	@Override
	public List<BookingRoom> getAllBookingRooms() {
		// TODO Auto-generated method stub
		return bookingRoomDAO.get();
	}
}
