package com.rustudor.business.mediator.comand;

import com.rustudor.business.mediator.Request;

public class AddPlaneCommand implements Request {
    private String s;

    public AddPlaneCommand(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
