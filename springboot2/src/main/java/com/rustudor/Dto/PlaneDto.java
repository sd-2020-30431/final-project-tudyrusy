package com.rustudor.Dto;

public class PlaneDto {
    private String model;
    private String status;

    public PlaneDto(String model, String status) {
        this.model = model;
        this.status = status;
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
