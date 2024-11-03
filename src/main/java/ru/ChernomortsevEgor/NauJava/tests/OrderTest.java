package ru.ChernomortsevEgor.NauJava.tests;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Courier;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Order;
import ru.ChernomortsevEgor.NauJava.repository.CourierRepository;
import ru.ChernomortsevEgor.NauJava.repository.OrderRepository;

@SpringBootTest
public class OrderTest {
    private final OrderRepository orderRepository;
    private final CourierRepository courierRepository;

    @Autowired
    public OrderTest(OrderRepository orderRepository, CourierRepository courierRepository)
    {
        this.orderRepository = orderRepository;
        this.courierRepository = courierRepository;
    }

    @Test
    @Transactional
    @Rollback
    void testFindByStatusAndCourierId()
    {
        Order order = new Order();
        Courier courier = new Courier();
        order.setCourier(courier);
        order.setStatus("ready");
        orderRepository.save(order);
        courierRepository.save(courier);

        Order foundOrder = orderRepository.findByStatusAndCourierId("ready", courier.getId()).getFirst();
        Assertions.assertNotNull(foundOrder);
        Assertions.assertEquals("ready", foundOrder.getStatus());
        Assertions.assertEquals(courier.getId(), foundOrder.getCourier().getId());

    }
}
