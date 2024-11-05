package ru.ChernomortsevEgor.NauJava.transaction;

import ru.ChernomortsevEgor.NauJava.PojoClasses.User;

public interface UserService {
    User findByUsername(String username);
    boolean addUser(User user);
}
