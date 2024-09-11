package com.hms;

import javax.persistence.*;

@Entity
public class Drivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Driver_Id", nullable = false)
    private Long driver_id;

    @Column(name = "Driver_Name", length = 50, nullable = false)
    private String driver_name;

    @Column(name = "Driver_Gender", length = 25, nullable = false)
    private String driver_gender;

    @Column(name = "Car_Brand", length = 50, nullable = false)
    private String car_brand;

    @Column(name = "Vehicle_Number", length = 50, nullable = false) // Added new column
    private String vehicle_number;

    @Column(name = "Availability", length = 25, nullable = false)
    private String availability;

    @Column(name = "Location", length = 30, nullable = false)
    private String location;

    @Column(name = "Company", length = 25, nullable = false)
    private String company;

    @OneToOne
    @JoinColumn(name = "Cust_Id", nullable = false)
    private Customers customer;
    
    // Getters and Setters
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

    public String getVehicleNumber() {
        return vehicle_number;
    }

    public void setVehicleNumber(String vehicle_number) {
        this.vehicle_number = vehicle_number;
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
    public Drivers(String driver_name, String driver_gender, String car_brand,
                   String vehicle_number, String availability, String location, 
                   String company, Customers customer) {
        this.driver_name = driver_name;
        this.driver_gender = driver_gender;
        this.car_brand = car_brand;
        this.vehicle_number = vehicle_number; // Initialize new field
        this.availability = availability;
        this.location = location;
        this.company = company;
        this.customer = customer;
    }

    public Drivers() {
    }

    // toString method
    @Override
    public String toString() {
        return "Drivers [driver_id=" + driver_id + ", driver_name=" + driver_name + ", driver_gender=" + driver_gender
                + ", car_brand=" + car_brand + ", vehicle_number=" + vehicle_number + ", availability=" + availability
                + ", location=" + location + ", company=" + company + ", customer=" + customer + "]";
    }
}
