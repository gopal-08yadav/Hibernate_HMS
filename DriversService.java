package Services;


import com.hms.Drivers;
import java.util.List;

public interface DriversService {
    // Create
    Drivers createDriver(Drivers driver);
    
    // Read
   // Drivers getDriverById(String driverId);
    Drivers getDriverById(Long driverId);
    // Update
    Drivers updateDriver(Long driverId, Drivers driver);
    
    // Delete
    Long deleteDriver(Long driverId);
    
    // List all drivers
    List<Drivers> getAllDrivers();

	
    Drivers requestPickup(Drivers driver);

	
}
