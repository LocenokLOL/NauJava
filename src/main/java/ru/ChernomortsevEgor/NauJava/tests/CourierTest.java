package ru.ChernomortsevEgor.NauJava.tests;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Courier;
import ru.ChernomortsevEgor.NauJava.repository.CourierRepository;

import java.util.UUID;

@SpringBootTest
public class CourierTest {
    private final CourierRepository courierRepository;

    @Autowired
    public CourierTest(CourierRepository courierRepository)
    {
        this.courierRepository = courierRepository;
    }

    @Test
    @Transactional
    @Rollback
    void testFindByNameAndStatus()
    {
        String courierName = UUID.randomUUID().toString();
        Courier courier = new Courier();
        courier.setName(courierName);
        courier.setStatus("ready");
        courierRepository.save(courier);
        Courier foundCourier = courierRepository.findByNameAndStatus(courierName, "ready").getFirst();
        Assertions.assertNotNull(foundCourier);
        Assertions.assertEquals(courierName, foundCourier.getName());
        Assertions.assertEquals("ready", foundCourier.getStatus());
    }
}
