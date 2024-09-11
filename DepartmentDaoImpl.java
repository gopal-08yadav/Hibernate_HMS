package com.hms.DaoImp;


import com.hms.Department;
import com.hms.Dao.DepartmentDao;
import com.hms.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private final SessionFactory sessionFactory;

    public DepartmentDaoImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
	public Department createDepartment(Department department) {
	
			try(Session session=HibernateUtil.getSession()) {
				
				session.beginTransaction();
				session.save(department);
				session.getTransaction().commit();
				//return department;
				
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
    public Department getDepartmentById(Long depart_id) {
        Session session = sessionFactory.openSession();
        Department department = session.get(Department.class, depart_id);
        session.close();
        return department;
    }

    @Override
    public Department updateDepartment(Long depart_id, Department updateDepartment) {
		try(Session session=HibernateUtil.getSession()) {
			Department department=session.get(Department.class, depart_id);
				session.beginTransaction();
				department.setDepartmentDiv(updateDepartment.getDepartmentDiv());
				department.setBudget(updateDepartment.getBudget());
				
				session.saveOrUpdate(department);
				session.getTransaction().commit();
				return department;
			
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
    public Department deleteDepartment(Long depart_id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Department department = session.get(Department.class, depart_id);
        if (department != null) {
            session.delete(department);
        }
        transaction.commit();
        session.close();
		return department;
    }

    @Override
    public List<Department> getAllDepartments() {
        Session session = sessionFactory.openSession();
        Query<Department> query = session.createQuery("FROM Department", Department.class);
        List<Department> departments = query.list();
        session.close();
        return departments;
    }
}

