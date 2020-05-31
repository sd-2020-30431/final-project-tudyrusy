package com.rustudor.business.mediator.response;

import com.rustudor.Dto.FullPlaneDto;
import com.rustudor.business.mediator.Response;

public class GetPlaneR implements Response {
    private FullPlaneDto fullPlaneDto;

    public FullPlaneDto getFullPlaneDto() {
        return fullPlaneDto;
    }

    public void setFullPlaneDto(FullPlaneDto fullPlaneDto) {
        this.fullPlaneDto = fullPlaneDto;
    }

    public GetPlaneR(FullPlaneDto fullPlaneDto) {
        this.fullPlaneDto = fullPlaneDto;
    }
}
