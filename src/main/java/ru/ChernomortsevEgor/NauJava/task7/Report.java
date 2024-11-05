package ru.ChernomortsevEgor.NauJava.task7;

import jakarta.persistence.*;
import ru.ChernomortsevEgor.NauJava.Enums.Role;

@Entity
@Table(name = "Reports")
public class Report {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Status status;
    @Column
    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
