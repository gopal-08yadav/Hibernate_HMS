package com.hms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cust_Id", length = 10, nullable = false)
    private Long cust_id; 

    @Column(name = "Cust_Name", length = 50, nullable = false)
    private String custName;

    @Column(name = "Cust_Gender", length = 25, nullable = false)
    private String custGender;

    @Column(name = "Cust_Num")
    private String custNumber;

    @Column(name = "Deposit", length = 30, nullable = false)
    private String deposit;

    @Column(name = "Country", length = 25, nullable = false)
    private String country;

    @Column(name = "CheckInTime")
    private LocalDate checkInTime;

    // Getter and Setter methods
    public Long getCustId() {
        return cust_id;
    }

    public void setCustId(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustGender() {
        return custGender;
    }

    public void setCustGender(String custGender) {
        this.custGender = custGender;
    }

    public String getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(String custNumber) {
        this.custNumber = custNumber;
    }


    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public LocalDate getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDate checkInTime) {
        this.checkInTime = checkInTime;
    }

    // Constructor
    public Customers(String custName, String custGender, String custNumber, String deposit, String country, LocalDate checkInTime) {
      
        this.custName = custName;
        this.custGender = custGender;
        this.custNumber = custNumber;
        this.deposit = deposit;
        this.country = country;
        this.checkInTime = checkInTime;
    }

    // Default Constructor
    public Customers() {
    	super();
    }

    @Override
    public String toString() {
        return "Customers [cust_id=" + cust_id + ", custName=" + custName + ", custGender=" + custGender + ", custNumber=" + custNumber + ", deposit=" + deposit + ", country=" + country + ", checkInTime=" + checkInTime + "]";
    }
}
