package com.hms.DaoImp;


import com.hms.Drivers;
import com.hms.Dao.DriversDao;
import com.hms.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DriversDaoImpl implements DriversDao {

    private final SessionFactory sessionFactory;

    public DriversDaoImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Drivers createDriver(Drivers driver) {
    	try(Session session=HibernateUtil.getSession()) {
			
			session.beginTransaction();
			session.save(driver);
			session.getTransaction().commit();
			//return driver;
			
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
    public Drivers getDriverById(Long driver_id) {
        Session session = sessionFactory.openSession();
        Drivers driver = session.get(Drivers.class, driver_id);
        session.close();
        return driver;
    }

    @Override
    public Drivers updateDriver(Long driver_id,Drivers updateDriver) {
    	try(Session session=HibernateUtil.getSession()) {
    		Drivers drivers=session.get(Drivers.class, driver_id);
				session.beginTransaction();
				
				drivers.setDriverName(updateDriver.getDriverName());
				drivers.setDriverGender(updateDriver.getDriverGender());
				drivers.setCarBrand(updateDriver.getCarBrand());
				drivers.setAvailability(updateDriver.getAvailability());
				drivers.setLocation(updateDriver.getLocation());
				drivers.setCompany(updateDriver.getCompany());
				
				session.saveOrUpdate(drivers);
				session.getTransaction().commit();
				return drivers;
			
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
    public Drivers deleteDriver(Long driverId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Drivers driver = session.get(Drivers.class, driverId);
        if (driver != null) {
            session.delete(driver);
        }
        transaction.commit();
        session.close();
		return driver;
    }

    @Override
    public List<Drivers> getAllDrivers() {
        Session session = sessionFactory.openSession();
        Query<Drivers> query = session.createQuery("FROM Drivers", Drivers.class);
        List<Drivers> drivers = query.list();
        session.close();
        return drivers;
    }
    
    @Override
    public Drivers requestPickup(Drivers driver) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(driver); // Save the driver request with customer association
            session.getTransaction().commit();
            return driver;
        } catch (HibernateException e) {
            System.out.println(e);
            return null;
        }
    }
}
