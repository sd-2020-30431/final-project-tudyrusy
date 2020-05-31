package com.rustudor.business.mediator.response;

import com.rustudor.Dto.PlaneDto;
import com.rustudor.business.mediator.Response;

import java.util.List;

public class GetPlanesR implements Response {
    private List<PlaneDto> planeDtos;

    public GetPlanesR(List<PlaneDto> planeDtos) {
        this.planeDtos = planeDtos;
    }

    public List<PlaneDto> getPlaneDtos() {
        return planeDtos;
    }

    public void setPlaneDtos(List<PlaneDto> planeDtos) {
        this.planeDtos = planeDtos;
    }
}
