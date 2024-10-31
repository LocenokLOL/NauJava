package ru.ChernomortsevEgor.NauJava.Crud;
import java.util.List;

import ru.ChernomortsevEgor.NauJava.Classes.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishCrud implements Crud<Dish, Long>{
    private final List<Dish> dishContainer;

    @Autowired
    public DishCrud(List<Dish> dishContainer)
    {
        this.dishContainer = dishContainer;
    }

    @Override
    public void create(Dish dish) {
        dishContainer.add(dish);
    }

    @Override
    public Dish read(Long dishID) {
        return dishContainer.stream()
                .filter(dish -> dish.getId().equals(dishID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Dish dish) {
        for (int i = 0; i < dishContainer.size(); i++) {
            Dish obj = dishContainer.get(i);
            if (obj.getId().equals(dish.getId())) {
                dishContainer.set(i, dish);
                break; // if you only want to replace the first occurrence
            }
        }
    }

    @Override
    public void delete(Long dishID) {
        dishContainer.removeIf(dish -> dish.getId().equals(dishID));
    }
}
