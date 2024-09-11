package com.hms.DaoImp;



import com.hms.Drivers;
import com.hms.Food;
import com.hms.Dao.FoodDao;
import com.hms.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FoodDaoImple implements FoodDao {
	private final SessionFactory sessionFactory;
	 public FoodDaoImple() {
	        sessionFactory = new Configuration().configure().buildSessionFactory();
	    }

	@Override
    public Food createFood(Food Food) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(Food);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
		return null;
    }


    @Override
    public Food updateFood(Long foodId,Food food) {
    	try(Session session=HibernateUtil.getSession()) {
    		Food foods=session.get(Food.class, foodId);
				session.beginTransaction();
				
				foods.setFood_Name(food.getFood_Name());
				foods.setFood_Cost(food.getFood_Cost());
				
				session.saveOrUpdate(foods);
				session.getTransaction().commit();
				return foods;
			
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
    public Food deleteFood(Long foodId) {
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Food Food = session.get(Food.class, foodId);
            if (Food != null) {
                session.delete(Food);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
		return null;
    }

    @Override
    public Food getFoodById(Long foodId) {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Food.class, foodId);
        }
    }

    @Override
    public List<Food> getAllFoods() {
    	Session session = sessionFactory.openSession();
        Query<Food> query = session.createQuery("FROM Food", Food.class);
        List<Food> food = query.list();
        session.close();
        return food;
    }
}
