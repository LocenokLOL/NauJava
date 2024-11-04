package ru.ChernomortsevEgor.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Client;


import java.util.List;

@RepositoryRestResource(path = "clients")
public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByUsername(String username);
}
