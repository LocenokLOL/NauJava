package BL;

import Classes.Dish;

public interface DishService {
        void createDish(Long id,Double cost, String name);
        Dish findById(Long id);
        void deleteById(Long id);
        void updateCost(Long id, Double newCost);
}
