package com.rustudor.business.mediator.handler;

import com.rustudor.business.Services.QueryService;
import com.rustudor.business.mediator.Handler;
import com.rustudor.business.mediator.query.GetPlaneQ;
import com.rustudor.business.mediator.response.GetPlaneR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPlaneH implements Handler<GetPlaneQ, GetPlaneR> {
    private final QueryService queryService;

    @Autowired
    public GetPlaneH(QueryService queryService) {
        this.queryService = queryService;
    }

    @Override
    public GetPlaneR handle(GetPlaneQ getPlaneQ) {
        return new GetPlaneR(queryService.getPlane(getPlaneQ.getId()));
    }
}
