package com.rustudor.business.mediator.handler;

import com.rustudor.business.Services.CommandService;
import com.rustudor.business.mediator.Handler;
import com.rustudor.business.mediator.comand.SavePlaneC;
import com.rustudor.business.mediator.response.SavePlaneR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePlaneH implements Handler<SavePlaneC, SavePlaneR> {
    private final CommandService commandService;

    @Autowired
    public SavePlaneH(CommandService commandService) {
        this.commandService = commandService;
    }
    @Override
    public SavePlaneR handle(SavePlaneC savePlaneC) {
        commandService.savePlane(savePlaneC.getFullPlaneDto());
        return new SavePlaneR();
    }
}
