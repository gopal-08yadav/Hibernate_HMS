package com.hms.DaoImp;



import com.hms.Drivers;
import com.hms.Employees;
import com.hms.Dao.EmployeesDao;
import com.hms.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class EmployeesDaoImpl implements EmployeesDao {

    @Override
    public Employees createEmployee(Employees employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            return employee;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
		return null;
    }

    @Override
    public Employees getEmployeeByAadhar(Long emp_id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Employees.class, emp_id);
        }
    }

    @Override
    public Employees updatedEmployee(Long emp_id,Employees updatedEmployee) {
    	try(Session session=HibernateUtil.getSession()) {
    		Employees employees=session.get(Employees.class, emp_id);
				session.beginTransaction();
				
				employees.setEmpName(updatedEmployee.getEmpName());
				employees.setEmpGender(updatedEmployee.getEmpGender());
				employees.setEmpAge(updatedEmployee.getEmpAge());
				employees.setEmpSalary(updatedEmployee.getEmpSalary());
				employees.setEmpPhone(updatedEmployee.getEmpPhone());
				employees.setEmpEmail(updatedEmployee.getEmpEmail());
				employees.setEmpJob(updatedEmployee.getEmpJob());
				
				session.saveOrUpdate(employees);
				session.getTransaction().commit();
				return employees;
			
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
    public Employees deleteEmployee(Long emp_id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employees employee = session.get(Employees.class, emp_id);
            if (employee != null) {
                session.delete(employee);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
		return null;
    }

    @Override
    public List<Employees> getAllEmployees() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Employees> query = session.createQuery("from Employees", Employees.class);
            return query.list();
        }
    }

	
}
