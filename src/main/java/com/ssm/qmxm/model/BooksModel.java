package com.ssm.qmxm.model;

public class BooksModel {
    public String boId;
    public String boName;
    public String boNumber;
    public String boPrice;
    public String boIntroduction;
    public String boRecommended;
    public String boPhoto;
    public String boCid="";
    public String boInventory;
    public String boSalt;
    public String boAuthor;
    public String clId;
    public String clType;

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public String getBoName() {
        return boName;
    }

    public void setBoName(String boName) {
        this.boName = boName;
    }

    public String getBoNumber() {
        return boNumber;
    }

    public void setBoNumber(String boNumber) {
        this.boNumber = boNumber;
    }

    public String getBoPrice() {
        return boPrice;
    }

    public void setBoPrice(String boPrice) {
        this.boPrice = boPrice;
    }

    public String getBoIntroduction() {
        return boIntroduction;
    }

    public void setBoIntroduction(String boIntroduction) {
        this.boIntroduction = boIntroduction;
    }

    public String getBoRecommended() {
        return boRecommended;
    }

    public void setBoRecommended(String boRecommended) {
        this.boRecommended = boRecommended;
    }

    public String getBoPhoto() {
        return boPhoto;
    }

    public void setBoPhoto(String boPhoto) {
        this.boPhoto = boPhoto;
    }

    public String getBoCid() {
        return boCid;
    }

    public void setBoCid(String boCid) {
        this.boCid = boCid;
    }

    public String getBoInventory() {
        return boInventory;
    }

    public void setBoInventory(String boInventory) {
        this.boInventory = boInventory;
    }

    public String getBoSalt() {
        return boSalt;
    }

    public void setBoSalt(String boSalt) {
        this.boSalt = boSalt;
    }

    public String getBoAuthor() {
        return boAuthor;
    }

    public void setBoAuthor(String boAuthor) {
        this.boAuthor = boAuthor;
    }

    public String getClId() {
        return clId;
    }

    public void setClId(String clId) {
        this.clId = clId;
    }

    public String getClType() {
        return clType;
    }

    public void setClType(String clType) {
        this.clType = clType;
    }

    @Override
    public String toString() {
        return "BooksModel{" +
                "boId='" + boId + '\'' +
                ", boName='" + boName + '\'' +
                ", boNumber='" + boNumber + '\'' +
                ", boPrice='" + boPrice + '\'' +
                ", boIntroduction='" + boIntroduction + '\'' +
                ", boRecommended='" + boRecommended + '\'' +
                ", boPhoto='" + boPhoto + '\'' +
                ", boCid='" + boCid + '\'' +
                ", boInventory='" + boInventory + '\'' +
                ", boSalt='" + boSalt + '\'' +
                ", boAuthor='" + boAuthor + '\'' +
                ", clId='" + clId + '\'' +
                ", clType='" + clType + '\'' +
                '}';
    }
}
