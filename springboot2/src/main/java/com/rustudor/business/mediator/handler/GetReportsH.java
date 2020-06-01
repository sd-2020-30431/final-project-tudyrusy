package com.rustudor.business.mediator.handler;

import com.rustudor.business.Services.QueryService;
import com.rustudor.business.mediator.Handler;
import com.rustudor.business.mediator.query.GetReportsQ;
import com.rustudor.business.mediator.response.GetReportsR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetReportsH implements Handler<GetReportsQ, GetReportsR> {
    private final QueryService queryService;

    @Autowired
    public GetReportsH(QueryService queryService) {
        this.queryService = queryService;
    }
    @Override
    public GetReportsR handle(GetReportsQ getReportsQ) {
        return new GetReportsR(queryService.getReports());
    }
}
