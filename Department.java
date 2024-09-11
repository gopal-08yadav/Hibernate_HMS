package com.hms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Depart_Id", nullable = false)
    private Long departId; 

    @Column(name = "Department_Div", length = 50, nullable = false)
    private String departmentDiv;

    @Column(name = "Budget", nullable = false)
    private String budget;
    
    // Default Constructor
    public Department() {
        super();
    }

    // All Argument Constructor
    public Department(String departmentDiv, String budget) {
        this.departmentDiv = departmentDiv;
        this.budget = budget;
    }
    
    // Getter and Setter for departId
    public Long getDepartId() {
        return departId;
    }

    public void setDepartId(Long departId) {
        this.departId = departId;
    }

    // Getter and Setter for departmentDiv
    public String getDepartmentDiv() {
        return departmentDiv;
    }

    public void setDepartmentDiv(String departmentDiv) {
        this.departmentDiv = departmentDiv;
    }

    // Getter and Setter for budget
    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    // toString Method
    @Override
    public String toString() {
        return "Department [departId=" + departId + ", departmentDiv=" + departmentDiv + ", budget=" + budget + "]";
    }
}
