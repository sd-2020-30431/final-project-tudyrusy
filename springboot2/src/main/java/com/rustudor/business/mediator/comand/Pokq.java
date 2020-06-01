package com.rustudor.business.mediator.comand;

import com.rustudor.business.mediator.Request;

public class Pokq implements Request {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pokq(int id) {
        this.id = id;
    }
}
