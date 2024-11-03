package ru.ChernomortsevEgor.NauJava.tests;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Cafe;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Dish;
import ru.ChernomortsevEgor.NauJava.repository.CafeRepository;
import ru.ChernomortsevEgor.NauJava.repository.DishRepository;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class DishTest {
    private final DishRepository dishRepository;
    private final CafeRepository cafeRepository;

    @Autowired
    public DishTest(DishRepository dishRepository, CafeRepository cafeRepository) {
        this.dishRepository = dishRepository;
        this.cafeRepository = cafeRepository;
    }

    @Test
    void testFindDishByCafe()
    {
        Cafe cafe = new Cafe();
        cafeRepository.save(cafe);
        Dish dish = new Dish();
        dish.setCafe(cafe);
        dishRepository.save(dish);
        Dish foundDish = dishRepository.findByCafe(cafe).getFirst();

        Assertions.assertNotNull(foundDish);
        Assertions.assertEquals(dish.getId(), foundDish.getId());
    }

    @Test
    @Transactional
    @Rollback
    void findDishByName()
    {
        String dishName = UUID.randomUUID().toString();
        Dish dish = new Dish();
        dish.setName(dishName);
        dishRepository.save(dish);
        Dish foundDish = dishRepository.findByName(dishName).getFirst();
        Assertions.assertNotNull(foundDish);
        Assertions.assertEquals(dish.getId(), foundDish.getId());
        Assertions.assertEquals(dishName, foundDish.getName());
    }
    @Test
    void findByCaloriesBetween()
    {
        Dish dish = new Dish();
        dish.setCalories(150);;
        dishRepository.save(dish);
        Dish foundDish = dishRepository.findByCaloriesBetween(101, 153).getFirst();
        Assertions.assertNotNull(foundDish);
        Assertions.assertEquals(foundDish.getCalories(), 150);
    }
}
