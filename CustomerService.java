package Services;

import com.hms.Customers;

import java.util.List;

public interface CustomerService {
    Customers createCustomer(Customers customer);
    List<Customers> getAllCustomers();
    Customers getCustomer(Long custId);
    Customers updateCustomer(Long custId,Customers customer);
    void deleteCustomer(Long custId);
	
   
}
