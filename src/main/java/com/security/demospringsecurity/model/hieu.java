package com.security.demospringsecurity.model;

public class hieu {
    private String hieu;
    private String deptrai;

    public hieu(String hieu, String deptrai) {
        this.hieu = hieu;
        this.deptrai = deptrai;
    }

    public String getHieu() {
        return hieu;
    }

    public void setHieu(String hieu) {
        this.hieu = hieu;
    }

    public String getDeptrai() {
        return deptrai;
    }

    public void setDeptrai(String deptrai) {
        this.deptrai = deptrai;
    }
}
