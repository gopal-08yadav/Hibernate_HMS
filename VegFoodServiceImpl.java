package com.hms.serviceImp;

import com.hms.VegFood;
import com.hms.Dao.DepartmentDao;
import com.hms.Dao.VegFoodDao;
import com.hms.DaoImp.DepartmentDaoImpl;
import com.hms.DaoImp.VegFoodDaoImpl;

import Services.VegFoodService;

import java.util.List;

public class VegFoodServiceImpl implements VegFoodService {

	VegFoodDao vegFoodDao =new VegFoodDaoImpl();

    @Override
    public VegFood addVegFood(VegFood vegFood) {
        return vegFoodDao.addVegFood(vegFood);
		
    }

    @Override
    public VegFood getVegFoodById(Long id) {
        return vegFoodDao.getVegFoodById(id);
    }

    @Override
    public List<VegFood> getAllVegFoods() {
        return vegFoodDao.getAllVegFoods();
    }

    @Override
    public VegFood updateVegFood(Long id,VegFood vegFood) {
        return vegFoodDao.updateVegFood(id,vegFood);
    }

    @Override
    public void deleteVegFood(Long id) {
        vegFoodDao.deleteVegFood(id);
    }
}
