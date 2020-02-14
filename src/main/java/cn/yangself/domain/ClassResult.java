package cn.yangself.domain;

import java.io.Serializable;

public class ClassResult implements Serializable {
    private String sName;
    private String sClass;
    private Double myTemp;
    private Double faTemp;
    private Double moTemp;
    private String state;

    public ClassResult() {
    }

    public ClassResult(String sName, String sClass, Double myTemp, Double faTemp, Double moTemp, String state) {
        this.sName = sName;
        this.sClass = sClass;
        this.myTemp = myTemp;
        this.faTemp = faTemp;
        this.moTemp = moTemp;
        this.state = state;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public Double getMyTemp() {
        return myTemp;
    }

    public void setMyTemp(Double myTemp) {
        this.myTemp = myTemp;
    }

    public Double getFaTemp() {
        return faTemp;
    }

    public void setFaTemp(Double faTemp) {
        this.faTemp = faTemp;
    }

    public Double getMoTemp() {
        return moTemp;
    }

    public void setMoTemp(Double moTemp) {
        this.moTemp = moTemp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "ClassResult{" +
                "sName='" + sName + '\'' +
                ", sClass='" + sClass + '\'' +
                ", myTemp=" + myTemp +
                ", faTemp=" + faTemp +
                ", moTemp=" + moTemp +
                ", state='" + state + '\'' +
                '}';
    }
}
