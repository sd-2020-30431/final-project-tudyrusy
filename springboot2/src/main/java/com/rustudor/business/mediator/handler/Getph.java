package com.rustudor.business.mediator.handler;

import com.rustudor.business.Services.QueryService;
import com.rustudor.business.mediator.Handler;
import com.rustudor.business.mediator.query.Getpq;
import com.rustudor.business.mediator.response.Getpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Getph implements Handler<Getpq, Getpr> {
    private final QueryService queryService;

    @Autowired
    public Getph(QueryService queryService) {
        this.queryService = queryService;
    }
    @Override
    public Getpr handle(Getpq getpq) {
        return new Getpr(queryService.getp(getpq.getUsername()));
    }
}
