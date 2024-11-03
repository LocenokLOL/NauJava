package ru.ChernomortsevEgor.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Client;


import java.util.List;


public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByUsername(String username);
}
