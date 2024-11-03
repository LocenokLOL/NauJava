package ru.ChernomortsevEgor.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Courier;

import java.util.List;

public interface CourierRepository extends CrudRepository<Courier, Long> {
    List<Courier> findByNameAndStatus(String name, String status);
}
