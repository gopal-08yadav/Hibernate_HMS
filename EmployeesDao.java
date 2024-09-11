package com.hms.Dao;


import com.hms.Employees;
import java.util.List;

public interface EmployeesDao {
    // Create
	Employees createEmployee(Employees employee);
    
    // Read
    Employees getEmployeeByAadhar(Long emp_id);
    
    // Update
    //Employees updateEmployee(Long emp_id);
    Employees updatedEmployee(Long emp_id,Employees updatedemployee);
    
    // Delete
    Employees deleteEmployee(Long emp_id);
    
    // List all employees
    List<Employees> getAllEmployees();

	
}
