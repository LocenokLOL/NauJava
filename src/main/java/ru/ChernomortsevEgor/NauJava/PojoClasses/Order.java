package ru.ChernomortsevEgor.NauJava.PojoClasses;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private double cost;

    @Column
    private String status;

    @Column
    private String address;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Courier courier;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Courier getCourier() {
        return courier;
    }
}
