package com.rustudor.business.factory;

import com.rustudor.entity.Plane;

public class DetailedReport implements Report {
    @Override
    public String makeReport(Plane plane) {
        String r = "";
        String status = "";
        String es, lgs, ws;
        if (plane.getOk() == 0)
            status = "unchecked";
        else if (plane.getOk() == 1)
            status = "all good";
        else
            status = "problem";

        if (plane.getEngine().getStatus() == 0)
            es = "unchecked";
        else if (plane.getEngine().getStatus() == 1)
            es = "all good";
        else
            es = "problem";

        if (plane.getWings().getStatus() == 0)
            ws = "unchecked";
        else if (plane.getWings().getStatus() == 1)
            ws = "all good";
        else
            ws = "problem";

        if (plane.getLandingGear().getStatus() == 0)
            lgs = "unchecked";
        else if (plane.getLandingGear().getStatus() == 1)
            lgs = "all good";
        else
            lgs = "problem";

        r += "Plane status: " + status + "\n   -Plane engine status: " + es + "\n     Details:" + plane.getEngine().getDescription() +
                "\n   -Plane wings status: " + ws+"\n     Details:" + plane.getWings().getDescription()
                + "\n   -Plane landing gear status: " + lgs+"\n     Details:" + plane.getLandingGear().getDescription();

        return r;
    }
}
