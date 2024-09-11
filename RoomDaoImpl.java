package com.hms.DaoImp;

import com.hms.Customers;
import com.hms.Room;
import com.hms.Dao.RoomDao;
import com.hms.util.HibernateUtil;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class RoomDaoImpl implements RoomDao {
	Scanner sc=new Scanner(System.in);
    @Override
    public Room getRoomByNumber(Long room_id) {
    	try(Session session=HibernateUtil.getSession()) {
			
			Room room=session.get(Room.class, room_id);
				return room;
			}
			catch (HibernateException e) {
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println(e);
			}
			
			return null;
    }

    @Override
    public Room saveRoom(Room room) {
    	try(Session session=HibernateUtil.getSession()) {
			
			session.beginTransaction();
			session.save(room);
			session.getTransaction().commit();
			return room;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
    }

    @Override
    public Room updateRoom(Long room_id,Room updatedroom) {
    	try(Session session=HibernateUtil.getSession()) {
    		Room rooms=session.get(Room.class, room_id);
				session.beginTransaction();
				
				rooms.setRoomNumber(updatedroom.getRoomNumber());
				rooms.setAvailability(updatedroom.getAvailability());
				rooms.setCleanStatus(updatedroom.getCleanStatus());
				rooms.setPrice(updatedroom.getPrice());
				rooms.setBedType(updatedroom.getBedType());
				
				
				session.saveOrUpdate(rooms);
				session.getTransaction().commit();
				return rooms;
				}
			
    }

    @Override
    public void deleteRoom(Long room_id) {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Room rooms = session.get(Room.class, room_id);
            if (rooms != null) {
                session.delete(rooms);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

	@Override
	public List<Room> getAllRooms() {
try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Room> query=session.createQuery("FROM Room");
			List<Room> roomsList=query.list();
			return roomsList;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
}
