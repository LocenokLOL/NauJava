package ru.ChernomortsevEgor.NauJava.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Order;

import java.util.List;

@RepositoryRestResource(path = "orders")
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByStatusAndCourierId(String courierStatus, Long courierID);
}
