package ru.ChernomortsevEgor.NauJava.PojoClasses;

import jakarta.persistence.*;

@Entity
@Table(name = "Clients")
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String username;

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
