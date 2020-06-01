package com.rustudor.business.mediator.handler;

import com.rustudor.business.Services.QueryService;
import com.rustudor.business.mediator.Handler;
import com.rustudor.business.mediator.query.GetPilotsQ;
import com.rustudor.business.mediator.response.GetPilotsR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPilotsH implements Handler<GetPilotsQ, GetPilotsR> {
    private final QueryService queryService;

    @Autowired
    public GetPilotsH(QueryService queryService) {
        this.queryService = queryService;
    }
    @Override
    public GetPilotsR handle(GetPilotsQ getPilotsQ) {
        return new GetPilotsR(queryService.getPilots());
    }
}
