package com.hms.serviceImp;

import com.hms.Food;
import com.hms.Dao.FoodDao;
import com.hms.DaoImp.FoodDaoImple;
import Services.FoodService;

import java.util.List;

public class FoodServiceImple implements FoodService {

    private FoodDao foodDao = new FoodDaoImple();

    @Override
    public Food createFood(Food food) {
        foodDao.createFood(food);
        return food;
    }

    @Override
    public Food getFood(Long foodId) {
        return foodDao.getFoodById(foodId);
    }

    @Override
    public Food updateFood(Long foodId, Food updatedFood) {
       return foodDao.updateFood(foodId,updatedFood);
    }

    @Override
    public Long deleteFood(Long foodId) {
        foodDao.deleteFood(foodId);
		return foodId;
    }

    @Override
    public List<Food> getAllFoods() {
        return foodDao.getAllFoods();
    }

	@Override
	public Food getFoodById(Long foodId) {
		// TODO Auto-generated method stub
		return  foodDao.getFoodById(foodId);
	}


	
}
