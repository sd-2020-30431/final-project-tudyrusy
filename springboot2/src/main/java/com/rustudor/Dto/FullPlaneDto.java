package com.rustudor.Dto;

public class FullPlaneDto {

    private int id;
    private String model;
    private String status;
    private int lgs;
    private String lgd;
    private int ws;
    private String wd;
    private int es;
    private String ed;

    public FullPlaneDto(int id, String model, String status, int lgs, String lgd, int ws, String wd, int es, String ed) {
        this.id = id;
        this.model = model;
        this.status = status;
        this.lgs = lgs;
        this.lgd = lgd;
        this.ws = ws;
        this.wd = wd;
        this.es = es;
        this.ed = ed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLgs() {
        return lgs;
    }

    public void setLgs(int lgs) {
        this.lgs = lgs;
    }

    public String getLgd() {
        return lgd;
    }

    public void setLgd(String lgd) {
        this.lgd = lgd;
    }

    public int getWs() {
        return ws;
    }

    public void setWs(int ws) {
        this.ws = ws;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public int getEs() {
        return es;
    }

    public void setEs(int es) {
        this.es = es;
    }

    public String getEd() {
        return ed;
    }

    public void setEd(String ed) {
        this.ed = ed;
    }
}
