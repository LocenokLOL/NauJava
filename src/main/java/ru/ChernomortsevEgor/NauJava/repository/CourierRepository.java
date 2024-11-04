package ru.ChernomortsevEgor.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Courier;

import java.util.List;

@RepositoryRestResource(path = "couriers")
public interface CourierRepository extends CrudRepository<Courier, Long> {
    List<Courier> findByNameAndStatus(String name, String status);
}
