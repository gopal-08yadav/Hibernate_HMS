package com.hms.serviceImp;



import com.hms.NonVegfood;

import com.hms.Dao.NonVegFoodDao;
import com.hms.Dao.VegFoodDao;
import com.hms.DaoImp.NonVegFoodDaoImpl;
import com.hms.DaoImp.VegFoodDaoImpl;

import Services.NonVegFoodService;

import java.util.List;

public class NonVegFoodServiceImpl implements NonVegFoodService {

	NonVegFoodDao nonVegFoodDao =new NonVegFoodDaoImpl();

    @Override
    public void addNonVegFood(NonVegfood nonVegFood) {
        nonVegFoodDao.addNonVegFood(nonVegFood);
    }

    @Override
    public NonVegfood getNonVegFoodById(Long id) {
        return nonVegFoodDao.getNonVegFoodById(id);
    }

    @Override
    public List<NonVegfood> getAllNonVegFoods() {
        return nonVegFoodDao.getAllNonVegFoods();
    }

    @Override
    public NonVegfood updateNonVegFood(Long id,NonVegfood nonVegFood) {
        return nonVegFoodDao.updateNonVegFood(id, nonVegFood);
    }

    @Override
    public void deleteNonVegFood(Long id) {
        nonVegFoodDao.deleteNonVegFood(id);
    }
}
