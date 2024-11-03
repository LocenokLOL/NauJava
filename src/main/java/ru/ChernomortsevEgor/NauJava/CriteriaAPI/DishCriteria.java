package ru.ChernomortsevEgor.NauJava.CriteriaAPI;

import ru.ChernomortsevEgor.NauJava.PojoClasses.Dish;

import java.util.List;

public interface DishCriteria {

    List<Dish> findById(long id);

    List<Dish> findByCafeID(long id);
}
