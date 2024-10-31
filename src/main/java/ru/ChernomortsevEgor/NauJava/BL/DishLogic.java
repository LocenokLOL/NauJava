package ru.ChernomortsevEgor.NauJava.BL;

import ru.ChernomortsevEgor.NauJava.Classes.Dish;
import ru.ChernomortsevEgor.NauJava.Crud.DishCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishLogic implements DishService
{
    private final DishCrud dishRepository;
    @Autowired
    public DishLogic(DishCrud dishRepository)
    {
        this.dishRepository = dishRepository;
    }

    @Override
    public void createDish(Long id, Double cost, String name) {
        Dish newDish = new Dish();
        newDish.setId(id);
        newDish.setCost(cost);
        newDish.setName(name);
        dishRepository.create(newDish);
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.read(id);
    }

    @Override
    public void deleteById(Long id) {
        dishRepository.delete(id);
    }

    @Override
    public void updateCost(Long id, Double newCost) {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setCost(newCost);
        dishRepository.update(dish);
    }
}
