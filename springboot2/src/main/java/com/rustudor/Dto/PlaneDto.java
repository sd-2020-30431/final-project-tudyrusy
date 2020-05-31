package com.rustudor.Dto;

public class PlaneDto {
    int id;
    private String model;
    private String status;

    public PlaneDto(int id,String model, String status) {
        this.id = id;
        this.model = model;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
