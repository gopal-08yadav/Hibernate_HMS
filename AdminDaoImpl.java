package com.hms.DaoImp;


import com.hms.Admin;
import com.hms.Dao.AdminDao;
import com.hms.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDaoImpl implements AdminDao {

    @Override
    public void saveAdmin(Admin admin) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(admin);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Admin getAdminByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Admin WHERE username = :username", Admin.class)
                          .setParameter("username", username)
                          .uniqueResult();
        }
    }
}
