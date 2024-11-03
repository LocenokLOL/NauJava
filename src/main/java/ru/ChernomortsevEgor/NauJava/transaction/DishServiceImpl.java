package ru.ChernomortsevEgor.NauJava.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


import ru.ChernomortsevEgor.NauJava.PojoClasses.Dish;
import ru.ChernomortsevEgor.NauJava.repository.CafeRepository;

import ru.ChernomortsevEgor.NauJava.repository.DishRepository;


import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final PlatformTransactionManager transactionManager;
    private final CafeRepository cafeRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository, DishRepository dishRepository1, PlatformTransactionManager transactionManager,  CafeRepository cafeRepository) {
        this.dishRepository = dishRepository1;
        this.transactionManager = transactionManager;
        this.cafeRepository = cafeRepository;
    }


    @Override
    public void deleteCafeByID(long id) {
        TransactionStatus status = transactionManager.getTransaction(new
                DefaultTransactionDefinition());
        try
        {
            List<Dish> dishes = dishRepository.findByCafe(cafeRepository.findById(id).getFirst());
            for (Dish dish : dishes)
            {
                dishRepository.delete(dish);
            }
            cafeRepository.deleteById(id);
            transactionManager.commit(status);
        }
        catch (DataAccessException ex)
        {
            transactionManager.rollback(status);
            throw ex;
        }
    }
}
