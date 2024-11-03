package ru.ChernomortsevEgor.NauJava.PojoClasses;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Dishes")
public class Dish {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Cafe cafe;

    @ManyToOne
    private Order order;

    @Column
    private String name;

    @Column
    private int calories;

    @Column
    private String description;

    @Column
    private double cost;


    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
