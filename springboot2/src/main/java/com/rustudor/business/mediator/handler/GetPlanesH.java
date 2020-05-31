package com.rustudor.business.mediator.handler;

import com.rustudor.business.Services.QueryService;
import com.rustudor.business.mediator.Handler;
import com.rustudor.business.mediator.query.GetPlanesQ;
import com.rustudor.business.mediator.response.GetPlanesR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPlanesH implements Handler<GetPlanesQ, GetPlanesR> {
    private final QueryService queryService;

    @Autowired
    public GetPlanesH(QueryService queryService) {
        this.queryService = queryService;
    }
    @Override
    public GetPlanesR handle(GetPlanesQ getPlanesQ) {
        return new GetPlanesR(queryService.getPlanes());
    }
}
