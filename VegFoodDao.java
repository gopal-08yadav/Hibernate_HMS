package com.hms.Dao;



import com.hms.VegFood;
import java.util.List;

public interface VegFoodDao {
    VegFood addVegFood(VegFood vegFood);
    VegFood getVegFoodById(Long id);
    List<VegFood> getAllVegFoods();
    VegFood updateVegFood(Long id,VegFood vegFood);
    void deleteVegFood(Long id);
}

