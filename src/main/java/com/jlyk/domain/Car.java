package com.jlyk.domain;

import java.io.Serializable;

public class Car implements Serializable {

    private Integer cid;
    private String license;
    private String carName;
    private Integer inParking;

    @Override
    public String toString() {
        return "Car{" +
                "cid=" + cid +
                ", license='" + license + '\'' +
                ", carName='" + carName + '\'' +
                ", inParking=" + inParking +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getInParking() {
        return inParking;
    }

    public void setInParking(Integer inParking) {
        this.inParking = inParking;
    }
}
