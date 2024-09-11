package com.hms.Dao;

import com.hms.Food;

import java.util.List;

public interface FoodDao {
	Food createFood(Food food);
    Food updateFood(Long foodId,Food food);
    Food deleteFood(Long foodId);
    Food getFoodById(Long foodId);
    List<Food> getAllFoods();
}
