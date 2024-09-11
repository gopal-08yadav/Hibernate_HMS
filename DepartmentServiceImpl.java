package com.hms.serviceImp;




import com.hms.Department;
import com.hms.Dao.DepartmentDao;
import com.hms.DaoImp.DepartmentDaoImpl;
import Services.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

	DepartmentDao departmentDao =new DepartmentDaoImpl();

    @Override
    public Department createDepartment(Department department) {
        return departmentDao.createDepartment(department);
    }

    @Override
    public Department getDepartmentById(Long depart_id) {
        return departmentDao.getDepartmentById(depart_id);
    }

    @Override
    public Department updateDepartment(Long depart_id,Department department) {
        return departmentDao.updateDepartment(depart_id, department);
    }

    @Override
    public Long deleteDepartment(Long depart_id) {
        departmentDao.deleteDepartment(depart_id);
		return depart_id;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }


}
