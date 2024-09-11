package Services;


import com.hms.Employees;
import java.util.List;

public interface EmployeesService {
    // Create
    Employees createEmployee(Employees employees);
    
    // Read
    Employees getEmployeeByAadhar(Long employeeId);
    
    // Update
    Employees updatedEmployee(Long employeeId, Employees updatedEmployee);

    // Delete
    Long deleteEmployee(Long employeeId);
    
    // List all employees
    List<Employees> getAllEmployees();

	
	
}
