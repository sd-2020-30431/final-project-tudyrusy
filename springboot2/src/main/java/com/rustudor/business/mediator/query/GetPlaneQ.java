package com.rustudor.business.mediator.query;

import com.rustudor.business.mediator.Request;

public class GetPlaneQ implements Request {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GetPlaneQ(int id) {
        this.id = id;
    }
}
