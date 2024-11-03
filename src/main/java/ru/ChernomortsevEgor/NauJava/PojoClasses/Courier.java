package ru.ChernomortsevEgor.NauJava.PojoClasses;

import jakarta.persistence.*;

@Entity
@Table(name = "Couriers")
public class Courier {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private double rating;

    @Column
    private String status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
