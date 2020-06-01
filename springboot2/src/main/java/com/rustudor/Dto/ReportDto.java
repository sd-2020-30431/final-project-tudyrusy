package com.rustudor.Dto;

public class ReportDto {
    private int planeid;
    private String planemodel;
    private int planestatus;
    private String r;
    private String dr;

    public int getPlaneid() {
        return planeid;
    }

    public void setPlaneid(int planeid) {
        this.planeid = planeid;
    }

    public String getPlanemodel() {
        return planemodel;
    }

    public void setPlanemodel(String planemodel) {
        this.planemodel = planemodel;
    }

    public int getPlanestatus() {
        return planestatus;
    }

    public void setPlanestatus(int planestatus) {
        this.planestatus = planestatus;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public ReportDto(int planeid, String planemodel, int planestatus, String r, String dr) {
        this.planeid = planeid;
        this.planemodel = planemodel;
        this.planestatus = planestatus;
        this.r = r;
        this.dr = dr;
    }
}
