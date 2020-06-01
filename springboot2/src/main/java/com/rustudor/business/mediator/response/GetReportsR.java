package com.rustudor.business.mediator.response;

import com.rustudor.Dto.ReportDto;
import com.rustudor.business.mediator.Response;

import java.util.List;

public class GetReportsR implements Response {
    private List<ReportDto> reportDtos;

    public List<ReportDto> getReportDtos() {
        return reportDtos;
    }

    public void setReportDtos(List<ReportDto> reportDtos) {
        this.reportDtos = reportDtos;
    }

    public GetReportsR(List<ReportDto> reportDtos) {
        this.reportDtos = reportDtos;
    }
}
