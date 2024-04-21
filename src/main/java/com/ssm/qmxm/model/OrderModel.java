package com.ssm.qmxm.model;

import java.util.Date;

public class OrderModel {
    public String orId;
    public String orNumber;
    public String orBuyid;
    public String orNum;
    public String orName;
    public String orHouse;
    public String orTel;
    public String orYes;
    public Date orTime;
    public String orDeliver;
    public String orNames;

    public String getOrNames() {
        return orNames;
    }

    public void setOrNames(String orNames) {
        this.orNames = orNames;
    }

    public String getOrDeliver() {
        return orDeliver;
    }

    public void setOrDeliver(String orDeliver) {
        this.orDeliver = orDeliver;
    }

    public String getOrYes() {
        return orYes;
    }

    public void setOrYes(String orYes) {
        this.orYes = orYes;
    }

    public Date getOrTime() {
        return orTime;
    }

    public void setOrTime(Date orTime) {
        this.orTime = orTime;
    }

    public String getOrId() {
        return orId;
    }

    public void setOrId(String orId) {
        this.orId = orId;
    }

    public String getOrNumber() {
        return orNumber;
    }

    public void setOrNumber(String orNumber) {
        this.orNumber = orNumber;
    }

    public String getOrBuyid() {
        return orBuyid;
    }

    public void setOrBuyid(String orBuyid) {
        this.orBuyid = orBuyid;
    }

    public String getOrNum() {
        return orNum;
    }

    public void setOrNum(String orNum) {
        this.orNum = orNum;
    }

    public String getOrName() {
        return orName;
    }

    public void setOrName(String orName) {
        this.orName = orName;
    }

    public String getOrHouse() {
        return orHouse;
    }

    public void setOrHouse(String orHouse) {
        this.orHouse = orHouse;
    }

    public String getOrTel() {
        return orTel;
    }

    public void setOrTel(String orTel) {
        this.orTel = orTel;
    }
}
