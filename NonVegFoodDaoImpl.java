package com.hms.DaoImp;

import com.hms.NonVegfood;
import com.hms.VegFood;
import com.hms.Dao.NonVegFoodDao;
import com.hms.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NonVegFoodDaoImpl implements NonVegFoodDao {

	@Override
	public NonVegfood addNonVegFood(NonVegfood vegFood) {
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
    public NonVegfood getNonVegFoodById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(NonVegfood.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NonVegfood> getAllNonVegFoods() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from NonVegfood", NonVegfood.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public NonVegfood updateNonVegFood(Long id,NonVegfood nonVegFood) {
    	try(Session session=HibernateUtil.getSession()) {
    		NonVegfood VegFood=session.get(NonVegfood.class, id);
				session.beginTransaction();
				
				VegFood.setFood_name(nonVegFood.getFood_name());
				VegFood.setFood_cost(nonVegFood.getFood_cost());
				
				
				
				session.saveOrUpdate(VegFood);
				session.getTransaction().commit();
				return VegFood;
				}
			
    }

    @Override
    public void deleteNonVegFood(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            NonVegfood nonVegFood = session.get(NonVegfood.class, id);
            if (nonVegFood != null) {
                session.delete(nonVegFood);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
