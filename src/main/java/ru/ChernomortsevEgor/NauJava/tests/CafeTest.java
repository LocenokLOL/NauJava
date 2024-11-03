package ru.ChernomortsevEgor.NauJava.tests;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Cafe;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Dish;
import ru.ChernomortsevEgor.NauJava.repository.CafeRepository;
import ru.ChernomortsevEgor.NauJava.repository.DishRepository;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
public class CafeTest {

    private final CafeRepository cafeRepository;

    @Autowired
    public CafeTest(CafeRepository cafeRepository)
    {
        this.cafeRepository = cafeRepository;
    }

    @Test
    @Transactional
    @Rollback
    void testFindByRatingGreaterThanEqual()
    {
        Cafe cafe1 = new Cafe();
        Cafe cafe2 = new Cafe();
        Cafe cafe3 = new Cafe();
        cafe1.setRating(4.7);
        cafe2.setRating(4.8);
        cafe3.setRating(4.6);
        cafeRepository.save(cafe1);
        cafeRepository.save(cafe2);
        cafeRepository.save(cafe3);

        List<Cafe> firstFoundCafes = cafeRepository.findByRatingGreaterThanEqual(4.7);
        List<Cafe> secondFoundCafes = cafeRepository.findByRatingGreaterThanEqual(4);
        List<Cafe> thirdFoundCafes = cafeRepository.findByRatingGreaterThanEqual(5);

        Assertions.assertNotNull(firstFoundCafes);
        Assertions.assertEquals(2, firstFoundCafes.size());
        Assertions.assertEquals(3, secondFoundCafes.size());
        Assertions.assertEquals(0, thirdFoundCafes.size());
    }
    @Test
    @Transactional
    @Rollback
    void testFindByName()
    {
        String cafeName = UUID.randomUUID().toString();
        Cafe cafe = new Cafe();
        cafe.setName(cafeName);
        cafeRepository.save(cafe);

        Cafe foundCafe = cafeRepository.findByName(cafeName).getFirst();
        Assertions.assertNotNull(foundCafe);
        Assertions.assertEquals(cafeName, foundCafe.getName());

    }
}
