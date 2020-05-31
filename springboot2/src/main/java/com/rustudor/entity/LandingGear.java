package com.rustudor.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class LandingGear {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private int id;
    private int status;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
