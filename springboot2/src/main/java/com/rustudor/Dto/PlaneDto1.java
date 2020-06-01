package com.rustudor.Dto;

public class PlaneDto1 {
    private String model;
    private int pilotId;

    @Override
    public String toString() {
        return "PlaneDto1{" +
                "model='" + model + '\'' +
                ", pilotId=" + pilotId +
                '}';
    }

    public PlaneDto1(String model, int pilotId) {
        this.model = model;
        this.pilotId = pilotId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }
}
