package com.ssm.qmxm.model;

public class SellerModel {
    public int seId;
    public String seAccount;
    public String sePass;
    public String seSalt;
    public int seBan;

    public int getSeId() {
        return seId;
    }

    public void setSeId(int seId) {
        this.seId = seId;
    }

    public String getSeAccount() {
        return seAccount;
    }

    public void setSeAccount(String seAccount) {
        this.seAccount = seAccount;
    }

    public String getSePass() {
        return sePass;
    }

    public void setSePass(String sePass) {
        this.sePass = sePass;
    }

    public String getSeSalt() {
        return seSalt;
    }

    public void setSeSalt(String seSalt) {
        this.seSalt = seSalt;
    }

    public int getSeBan() {
        return seBan;
    }

    public void setSeBan(int seBan) {
        this.seBan = seBan;
    }
}
