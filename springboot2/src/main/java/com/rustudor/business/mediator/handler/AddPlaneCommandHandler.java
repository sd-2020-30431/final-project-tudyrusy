package com.rustudor.business.mediator.handler;

import com.rustudor.business.Services.CommandService;
import com.rustudor.business.mediator.Handler;
import com.rustudor.business.mediator.comand.AddPlaneCommand;
import com.rustudor.business.mediator.response.AddPlaneCommandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddPlaneCommandHandler implements Handler<AddPlaneCommand, AddPlaneCommandResponse> {
    private final CommandService commandService;

    @Autowired
    public AddPlaneCommandHandler(CommandService commandService) {
        this.commandService = commandService;
    }
    @Override
    public AddPlaneCommandResponse handle(AddPlaneCommand addPlaneCommand) {
        return new AddPlaneCommandResponse(commandService.addPlane(addPlaneCommand.getS()));
    }
}
