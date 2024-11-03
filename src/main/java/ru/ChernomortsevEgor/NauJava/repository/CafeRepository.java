package ru.ChernomortsevEgor.NauJava.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Cafe;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Dish;

public interface CafeRepository extends CrudRepository<Cafe, Long>
{
    List<Cafe> findByName(String name);
    List<Cafe> findByRatingGreaterThanEqual(double rating);
    List<Cafe> findById (long id);
}

