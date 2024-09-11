package com.hms.serviceImp;


import com.hms.Drivers;
import com.hms.Dao.DriversDao;
import com.hms.DaoImp.DriversDaoImpl;
import Services.DriversService;

import java.util.List;

public class DriversServiceImpl implements DriversService {

    private final DriversDao driversDao = new DriversDaoImpl();

    @Override
    public Drivers createDriver(Drivers driver) {
    	return driversDao.createDriver(driver);
    }

    @Override
    public Drivers getDriverById(Long driverId) {
        return driversDao.getDriverById(driverId);
    }

    @Override
    public Drivers updateDriver(Long driverId, Drivers driver) {
        return driversDao.updateDriver(driverId,driver);
    }

    @Override
    public Long deleteDriver(Long driverId) {
        driversDao.deleteDriver(driverId);
		return driverId;
    }

    @Override
    public List<Drivers> getAllDrivers() {
        return driversDao.getAllDrivers();
    }

    @Override
    public Drivers requestPickup(Drivers driver) {
        return driversDao.requestPickup(driver);
    }
}
