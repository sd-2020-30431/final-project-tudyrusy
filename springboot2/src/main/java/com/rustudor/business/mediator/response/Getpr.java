package com.rustudor.business.mediator.response;

import com.rustudor.business.mediator.Response;

public class Getpr implements Response {
    private int r;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Getpr(int r) {
        this.r = r;
    }
}
