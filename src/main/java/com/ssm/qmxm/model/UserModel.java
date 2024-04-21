package com.ssm.qmxm.model;

public class UserModel {
    public int buId;
    public String buAccount;
    public String buPass;
    public String buSalt;
    public String buOut;

    public String getBuOut() {
        return buOut;
    }

    public void setBuOut(String buOut) {
        this.buOut = buOut;
    }

    public int getBuId() {
        return buId;
    }

    public void setBuId(int buId) {
        this.buId = buId;
    }

    public String getBuAccount() {
        return buAccount;
    }

    public void setBuAccount(String buAccount) {
        this.buAccount = buAccount;
    }

    public String getBuPass() {
        return buPass;
    }

    public void setBuPass(String buPass) {
        this.buPass = buPass;
    }

    public String getBuSalt() {
        return buSalt;
    }

    public void setBuSalt(String buSalt) {
        this.buSalt = buSalt;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "buId=" + buId +
                ", buAccount='" + buAccount + '\'' +
                ", buPass='" + buPass + '\'' +
                ", buSalt='" + buSalt + '\'' +
                '}';
    }
}
