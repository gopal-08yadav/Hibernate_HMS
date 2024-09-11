package com.hms.DaoImp;

import com.hms.VegFood;
import com.hms.Dao.RoomAllocationDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RoomAllocationDAOImpl implements RoomAllocationDAO {

    private SessionFactory sessionFactory;

    public RoomAllocationDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveRoomAllocation(VegFood vegFood) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(vegFood);
        tx.commit();
        session.close();
    }

    @Override
    public VegFood getRoomAllocationById(String bookingId) {
        Session session = sessionFactory.openSession();
        VegFood vegFood = session.get(VegFood.class, bookingId);
        session.close();
        return vegFood;
    }

    @Override
    public List<VegFood> getAllRoomAllocations() {
        Session session = sessionFactory.openSession();
        Query<VegFood> query = session.createQuery("from RoomAllocation", VegFood.class);
        List<VegFood> vegFoods = query.list();
        session.close();
        return vegFoods;
    }

    @Override
    public void updateRoomAllocation(VegFood vegFood) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(vegFood);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteRoomAllocation(String bookingId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        VegFood vegFood = session.get(VegFood.class, bookingId);
        if (vegFood != null) {
            session.delete(vegFood);
        }
        tx.commit();
        session.close();
    }
}