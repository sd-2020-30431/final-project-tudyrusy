package com.rustudor.business.mediator.query;

import com.rustudor.business.mediator.Request;

public class Getpq implements Request {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Getpq(String username) {
        this.username = username;
    }
}
