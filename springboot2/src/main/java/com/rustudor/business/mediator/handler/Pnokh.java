package com.rustudor.business.mediator.handler;

import com.rustudor.business.Services.CommandService;
import com.rustudor.business.Services.QueryService;
import com.rustudor.business.mediator.Handler;
import com.rustudor.business.mediator.comand.Pnokq;
import com.rustudor.business.mediator.response.Pnokr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pnokh implements Handler<Pnokq, Pnokr> {
    private final CommandService commandService;

    @Autowired
    public Pnokh(CommandService commandService) {
        this.commandService = commandService;
    }
    @Override
    public Pnokr handle(Pnokq pnokq) {
        commandService.pnok(pnokq.getId());
        return new Pnokr();
    }
}
