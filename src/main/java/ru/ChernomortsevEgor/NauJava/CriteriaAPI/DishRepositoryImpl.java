package ru.ChernomortsevEgor.NauJava.CriteriaAPI;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Cafe;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Dish;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Order;
import java.time.LocalDate;
import java.util.List;

@Repository
public class DishRepositoryImpl implements DishCriteria {

   private final EntityManager entityManager;

   @Autowired
   public DishRepositoryImpl (EntityManager entityManager)
   {
        this.entityManager = entityManager;
   }

   @Override
   public List<Dish> findById(long id)
   {
       CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
       CriteriaQuery<Dish> criteriaQuery = criteriaBuilder.createQuery(Dish.class);
       Root<Dish> entryRoot = criteriaQuery.from(Dish.class);
       Join<Dish, Order> order = entryRoot.join("order", JoinType.INNER);
       Predicate namePredicate = criteriaBuilder.equal(order.get("id"), id);
       criteriaQuery.select(entryRoot).where(namePredicate);
       return entityManager.createQuery(criteriaQuery).getResultList();
   }


    @Override
    public List<Dish> findByCafeID(long id)
    {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Dish> criteriaQuery = criteriaBuilder.createQuery(Dish.class);
        Root<Dish> entryRoot = criteriaQuery.from(Dish.class);
        Join<Dish, Cafe> cafe = entryRoot.join("cafe", JoinType.INNER);
        Predicate namePredicate = criteriaBuilder.equal(cafe.get("id"), id);
        criteriaQuery.select(entryRoot).where(namePredicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}