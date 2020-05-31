package com.rustudor.business.mediator.comand;

import com.rustudor.Dto.FullPlaneDto;
import com.rustudor.business.mediator.Request;

public class SavePlaneC implements Request {
    private FullPlaneDto fullPlaneDto;

    public FullPlaneDto getFullPlaneDto() {
        return fullPlaneDto;
    }

    public void setFullPlaneDto(FullPlaneDto fullPlaneDto) {
        this.fullPlaneDto = fullPlaneDto;
    }

    public SavePlaneC(FullPlaneDto fullPlaneDto) {
        this.fullPlaneDto = fullPlaneDto;
    }
}
