package com.rustudor.business.mediator.handler;

import com.rustudor.business.Services.CommandService;
import com.rustudor.business.mediator.Handler;
import com.rustudor.business.mediator.comand.Pokq;
import com.rustudor.business.mediator.response.Pokr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pokh implements Handler<Pokq, Pokr> {
    private final CommandService commandService;

    @Autowired
    public Pokh(CommandService commandService) {
        this.commandService = commandService;
    }
    @Override
    public Pokr handle(Pokq pokq) {
        commandService.pok(pokq.getId());
        return new Pokr();
    }
}
