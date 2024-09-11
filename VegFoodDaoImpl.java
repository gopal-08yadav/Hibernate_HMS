package com.hms.DaoImp;

import com.hms.Room;
import com.hms.VegFood;
import com.hms.Dao.DepartmentDao;
import com.hms.Dao.VegFoodDao;
import com.hms.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class VegFoodDaoImpl implements VegFoodDao {
	//VegFoodDao vegFoodDao =new VegFoodDaoImpl();
	@Override
	public VegFood addVegFood(VegFood vegFood) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        session.save(vegFood);
	        transaction.commit();
	        return vegFood; // Return the saved object
	    } catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}


    @Override
    public VegFood getVegFoodById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(VegFood.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<VegFood> getAllVegFoods() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from VegFood", VegFood.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public VegFood updateVegFood(Long food_id,VegFood updateVegFood) {
    	try(Session session=HibernateUtil.getSession()) {
    		VegFood VegFood=session.get(VegFood.class, food_id);
				session.beginTransaction();
				
				VegFood.setFood_name(updateVegFood.getFood_name());
				VegFood.setFood_cost(updateVegFood.getFood_cost());
				
				
				
				session.saveOrUpdate(VegFood);
				session.getTransaction().commit();
				return VegFood;
				}
			
    }

    @Override
    public void deleteVegFood(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            VegFood vegFood = session.get(VegFood.class, id);
            if (vegFood != null) {
                session.delete(vegFood);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
