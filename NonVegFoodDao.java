package com.hms.Dao;



import com.hms.NonVegfood;
import java.util.List;

public interface NonVegFoodDao {
	NonVegfood addNonVegFood(NonVegfood nonVegFood);
    NonVegfood getNonVegFoodById(Long id);
    List<NonVegfood> getAllNonVegFoods();
    NonVegfood updateNonVegFood(Long id,NonVegfood nonVegFood);
    void deleteNonVegFood(Long id);
}

