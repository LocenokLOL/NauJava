package ru.ChernomortsevEgor.NauJava.tests;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Client;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Dish;
import ru.ChernomortsevEgor.NauJava.repository.ClientRepository;

import java.util.UUID;

@SpringBootTest
public class ClientTest {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientTest(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Test
    @Transactional
    @Rollback
    void findDishByName() {
        String username = UUID.randomUUID().toString();
        Client client = new Client();
        client.setUsername(username);
        clientRepository.save(client);
        Client foundClient = clientRepository.findByUsername(username).getFirst();
        Assertions.assertNotNull(foundClient);
        Assertions.assertEquals(username, foundClient.getUsername());
    }
}
