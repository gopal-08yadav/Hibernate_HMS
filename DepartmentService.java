package Services;


import com.hms.Department;
import java.util.List;

public interface DepartmentService {
    // Create
	Department createDepartment(Department department);
    
    // Read
    Department getDepartmentById(Long depart_id);
    
    // Update
    Department updateDepartment(Long depart_id, Department updatedDepartment);
    
    // Delete
    Long deleteDepartment(Long depart_id);
    
    // List all departments
    List<Department> getAllDepartments();

	

	
}

