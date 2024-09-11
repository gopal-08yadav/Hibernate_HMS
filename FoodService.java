package Services;



import com.hms.Food;
import java.util.List;

public interface FoodService {
	
    Food createFood(Food food);
    Food getFood(Long foodId);
    Long deleteFood(Long foodId);
    List<Food> getAllFoods();
	Food getFoodById(Long foodId);
	Food updateFood(Long foodId, Food updatedFood);
}

