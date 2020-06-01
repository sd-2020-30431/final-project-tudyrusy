package com.rustudor.business.mediator.response;

import com.rustudor.business.mediator.Response;

import java.util.List;

public class GetPilotsR implements Response {
    private List<Integer> pilots;

    public List<Integer> getPilots() {
        return pilots;
    }

    public void setPilots(List<Integer> pilots) {
        this.pilots = pilots;
    }

    public GetPilotsR(List<Integer> pilots) {
        this.pilots = pilots;
    }
}
