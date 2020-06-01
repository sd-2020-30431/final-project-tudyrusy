package com.rustudor.business.factory;

public class ReportFactory {
    public Report getReport(String type){
        if (type.equals("BRIEF"))
            return new BriefReport();
        else if (type.equals("DETAILED"))
            return new DetailedReport();
        else
            return null;
    }
}
