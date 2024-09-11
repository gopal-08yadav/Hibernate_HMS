package com.hms.serviceImp;



import com.hms.Employees;
import com.hms.Dao.EmployeesDao;
import com.hms.DaoImp.EmployeesDaoImpl;
import Services.EmployeesService;

import java.util.List;

public  class EmployeesServiceImpl implements EmployeesService {

    private final EmployeesDao employeesDao = new EmployeesDaoImpl();

    @Override
    public Employees createEmployee(Employees employee) {
        employeesDao.createEmployee(employee);
		return employee;
    }

    @Override
    public Employees getEmployeeByAadhar(Long empAadhar) {
        return employeesDao.getEmployeeByAadhar(empAadhar);
    }

    @Override
    public Employees updatedEmployee(Long emp_aadhar, Employees updatedEmployee) {
        return employeesDao.updatedEmployee(emp_aadhar,updatedEmployee);
    }

    @Override
    public Long deleteEmployee(Long empAadhar) {
        employeesDao.deleteEmployee(empAadhar);
		return empAadhar;
    }

    @Override
    public List<Employees> getAllEmployees() {
        return employeesDao.getAllEmployees();
    }


}
