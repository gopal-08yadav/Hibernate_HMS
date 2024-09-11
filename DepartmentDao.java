package com.hms.Dao;



import com.hms.Department;
import java.util.List;

public interface DepartmentDao {
    // Create
	Department createDepartment(Department department);
    
    // Read
    Department getDepartmentById(Long depart_id);
    
    // Update
    Department updateDepartment(Long depart_id,Department department);
    
    // Delete
    Department deleteDepartment(Long depart_id);
    
    // List all departments
    List<Department> getAllDepartments();
}

