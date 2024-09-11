package com.hms.DaoImp;


import com.hms.BookingRoom;
import com.hms.Customers;

import com.hms.Dao.CustomerDao;
import com.hms.util.HibernateUtil;
//import com.student.entity.Student;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CustomerDaoImpl implements CustomerDao {
	 Scanner sc=new Scanner(System.in);
	@Override
	public Customers createCustomers(Customers customers) {
	
			try(Session session=HibernateUtil.getSession()) {
				
				session.beginTransaction();
				session.save(customers);
				session.getTransaction().commit();
				return customers;
				
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
	    public Optional<Customers> findById(Long cust_id) {
	        Customers customer = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            customer = session.get(Customers.class, cust_id);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return Optional.ofNullable(customer);
	    }
	@Override
	public Customers getCustomers(Long cust_id) {
		
			try(Session session=HibernateUtil.getSession()) {
					
				Customers Customers=session.get(Customers.class, cust_id);
					return Customers;
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
	public List<Customers> getAllCustomers() {
		try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Customers> query=session.createQuery("FROM Customers");
			List<Customers> customersList=query.list();
			return customersList;
			
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
	public Customers updateCustomers(Long cust_id, Customers updatedCustomers) {
	    try (Session session = HibernateUtil.getSession()) {
	        // Fetch the customer entity by ID
	        Customers customer = session.get(Customers.class, cust_id);

	        if (customer != null) {
	            session.beginTransaction();

	            // Update customer details
	            customer.setCustName(updatedCustomers.getCustName());
	            customer.setCustGender(updatedCustomers.getCustGender());
	            customer.setCustNumber(updatedCustomers.getCustNumber());
	            customer.setDeposit(updatedCustomers.getDeposit());
	            customer.setCountry(updatedCustomers.getCountry());
	            customer.setCheckInTime(updatedCustomers.getCheckInTime());

	            session.saveOrUpdate(customer);  // Save or update the customer
	            session.getTransaction().commit();

	            return customer;
	        } else {
	            System.out.println("Customer with ID '" + cust_id + "' not found!");
	            return null;
	        }
	    } catch (HibernateException e) {
	        System.out.println(e);
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return null;
	}


    // Other methods...

	@Override
	public void deleteCustomers(Long cust_id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Customers customer = session.get(Customers.class, cust_id);
            if (customer != null) {
                session.delete(customer);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


}
	
}
