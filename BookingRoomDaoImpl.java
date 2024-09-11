package com.hms.DaoImp;


import com.hms.BookingRoom;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hms.Dao.BookingRoomDao;
import com.hms.util.HibernateUtil;
//import com.mysql.cj.Session;

import java.util.List;
import org.hibernate.Transaction;
import java.util.Optional;

public class BookingRoomDaoImpl implements BookingRoomDao {

    @Override
    public BookingRoom save(BookingRoom bookingRoom) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(bookingRoom);
            transaction.commit();
            return bookingRoom;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }

    @Override
    public Optional<BookingRoom> findById(Long bookingId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(BookingRoom.class, bookingId));
        }
    }

    @Override
    public void update(BookingRoom bookingRoom) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(bookingRoom);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long bookingId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            BookingRoom bookingRoom = session.get(BookingRoom.class, bookingId);
            if (bookingRoom != null) {
                session.delete(bookingRoom);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BookingRoom> get() {
        List<BookingRoom> bookingRooms = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            
            // Use HQL (Hibernate Query Language) to retrieve all BookingRoom objects
            String hql = "FROM BookingRoom";
            Query<BookingRoom> query = session.createQuery(hql, BookingRoom.class);
            bookingRooms = query.list(); // Execute the query and get the list of BookingRoom
            
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingRooms;
    
	}
}



