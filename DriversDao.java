package com.hms.Dao;


import com.hms.Drivers;
import java.util.List;

public interface DriversDao {
    // Create
	Drivers createDriver(Drivers driver);
    
    // Read
    Drivers getDriverById(Long driverId);
    
    // Update
    Drivers updateDriver(Long driverId,Drivers driver);
    
    // Delete
    Drivers deleteDriver(Long driverId);
    
    // List all drivers
    List<Drivers> getAllDrivers();
    Drivers requestPickup(Drivers driver);
}
