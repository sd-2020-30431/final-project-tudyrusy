package com.rustudor.business.mediator.response;

import com.rustudor.business.mediator.Response;

public class AddPlaneCommandResponse implements Response {
    private String s;

    public AddPlaneCommandResponse(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
