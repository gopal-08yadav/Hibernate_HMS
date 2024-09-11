package com.hms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employees {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Emp_Id", length = 50, nullable = false)
    private Long emp_id; // Changed field name to match the database column

    @Column(name = "Emp_Aadhar", length = 50, nullable = false)
    private String emp_aadhar;

    @Column(name = "Emp_Name", length = 50, nullable = false)
    private String emp_name;

    @Column(name = "Emp_Gender", length = 25, nullable = false)
    private String emp_gender;

    @Column(name = "Emp_Age", length = 20, nullable = false)
    private String emp_age;

    @Column(name = "Emp_Salary", length = 25, nullable = false)
    private String emp_salary;

    @Column(name = "Emp_Phone", length = 30, nullable = false)
    private String emp_phone;

    @Column(name = "Email", length = 50, nullable = false)
    private String email;

    @Column(name = "Emp_Job", length = 30, nullable = false)
    private String emp_job;

    // Getter and Setter methods
    public Long getEmpId() {
        return emp_id;
    }

    public void setEmpId(Long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmpAadhar() {
        return emp_aadhar;
    }

    public void setEmpAadhar(String emp_aadhar) {
        this.emp_aadhar = emp_aadhar;
    }

    public String getEmpName() {
        return emp_name;
    }

    public void setEmpName(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmpGender() {
        return emp_gender;
    }

    public void setEmpGender(String emp_gender) {
        this.emp_gender = emp_gender;
    }

    public String getEmpAge() {
        return emp_age;
    }

    public void setEmpAge(String emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmpSalary() {
        return emp_salary;
    }

    public void setEmpSalary(String emp_salary) {
        this.emp_salary = emp_salary;
    }

    public String getEmpPhone() {
        return emp_phone;
    }

    public void setEmpPhone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    public String getEmpEmail() {
        return email;
    }

    public void setEmpEmail(String email) {
        this.email = email;
    }

    public String getEmpJob() {
        return emp_job;
    }

    public void setEmpJob(String emp_job) {
        this.emp_job = emp_job;
    }

    // All-arguments Constructor
    public Employees(String emp_aadhar, String emp_name, String emp_gender, String emp_age,
                     String emp_salary, String emp_phone, String email, String emp_job) {
        this.emp_aadhar = emp_aadhar;
        this.emp_name = emp_name;
        this.emp_gender = emp_gender;
        this.emp_age = emp_age;
        this.emp_salary = emp_salary;
        this.emp_phone = emp_phone;
        this.email = email;
        this.emp_job = emp_job;
    }

    // Default Constructor
    public Employees() {
        super();
    }

    // toString method
    @Override
    public String toString() {
        return "Employees [emp_id=" + emp_id + ", emp_aadhar=" + emp_aadhar + ", emp_name=" + emp_name +
               ", emp_gender=" + emp_gender + ", emp_age=" + emp_age + ", emp_salary=" + emp_salary +
               ", emp_phone=" + emp_phone + ", email=" + email + ", emp_job=" + emp_job + "]";
    }
}
