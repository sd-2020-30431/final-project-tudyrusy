package com.rustudor.business.mediator.comand;

import com.rustudor.Dto.PlaneDto1;
import com.rustudor.business.mediator.Request;

public class AddPlaneCommand implements Request {
    private PlaneDto1 s;

    public PlaneDto1 getS() {
        return s;
    }

    public void setS(PlaneDto1 s) {
        this.s = s;
    }

    public AddPlaneCommand(PlaneDto1 s) {
        this.s = s;
    }
}
