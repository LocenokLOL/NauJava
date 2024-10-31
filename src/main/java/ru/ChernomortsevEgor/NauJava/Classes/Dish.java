package ru.ChernomortsevEgor.NauJava.Classes;

public class Dish {
    private Long id;
    private Double cost;
    private String name;
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public Double getCost()
    {
        return cost;
    }
    public void setCost(Double cost)
    {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
