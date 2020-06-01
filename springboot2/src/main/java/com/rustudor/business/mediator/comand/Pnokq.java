package com.rustudor.business.mediator.comand;

import com.rustudor.business.mediator.Request;

public class Pnokq implements Request {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pnokq(int id) {
        this.id = id;
    }
}
