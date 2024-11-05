package ru.ChernomortsevEgor.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.ChernomortsevEgor.NauJava.PojoClasses.User;


import java.util.List;

@RepositoryRestResource(path = "users")
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String Username);
}
