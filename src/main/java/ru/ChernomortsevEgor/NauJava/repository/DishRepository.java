package ru.ChernomortsevEgor.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Cafe;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Dish;

import java.util.List;

@RepositoryRestResource(path = "dishes")
public interface DishRepository extends CrudRepository<Dish, Long>
{
    List<Dish> findByCafe(Cafe cafe_id);
    List<Dish> findByCaloriesBetween(int first, int second);
    List<Dish> findByName(String name);
}
