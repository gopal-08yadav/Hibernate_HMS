package com.hms.association;

import javax.persistence.*;

import com.hms.Customers;

@Entity
public class OnetoOne {
    @Id
    @Column(name = "Driver_Id", length = 10)
    private Long driver_id;

    @Column(name = "Driver_Name", length = 50)
    private String driver_name;

    @Column(name = "Driver_Gender", length = 25)
    private String driver_gender;

    @Column(name = "Car_Brand")
    private String car_brand;

    @Column(name = "Availability", length = 25)
    private String availability;

    @Column(name = "Location", length = 30)
    private String location;

    @Column(name = "Company", length = 25)
    private String company;

    @OneToOne
    @JoinColumn(name = "Cust_Id")  // Foreign key column in the Drivers table
    private Customers customer;

    // Getter and Setter methods

    public Long getDriverId() {
        return driver_id;
    }

    public void setDriverId(Long driver_id) {
        this.driver_id = driver_id;
    }

    public String getDriverName() {
        return driver_name;
    }

    public void setDriverName(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getDriverGender() {
        return driver_gender;
    }

    public void setDriverGender(String driver_gender) {
        this.driver_gender = driver_gender;
    }

    public String getCarBrand() {
        return car_brand;
    }

    public void setCarBrand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    // Constructors
    public OnetoOne(Long driver_id, String driver_name, String driver_gender, String car_brand,
                   String availability, String location, String company, Customers customer) {
        this.driver_id = driver_id;
        this.driver_name = driver_name;
        this.driver_gender = driver_gender;
        this.car_brand = car_brand;
        this.availability = availability;
        this.location = location;
        this.company = company;
        this.customer = customer;
    }

    public OnetoOne() {
    	super();
    }

    @Override
    public String toString() {
        return "Drivers [driver_id=" + driver_id + ", driver_name=" + driver_name + ", driver_gender=" + driver_gender +
               ", car_brand=" + car_brand + ", availability=" + availability + ", location=" + location +
               ", company=" + company + ", customer=" + customer + "]";
    }
}
