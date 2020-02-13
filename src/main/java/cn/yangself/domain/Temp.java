package cn.yangself.domain;

import java.io.Serializable;

public class Temp implements Serializable {
    private Integer id ;
    private String tDate;
    private String tName ;
    private String mClass;
    private Double myTemp;
    private Double faTemp;
    private Double moTemp;

    public Temp() {
    }

    public Temp(Integer id, String tDate, String tName, String mClass, Double myTemp, Double faTemp, Double moTemp) {
        this.id = id;
        this.tDate = tDate;
        this.tName = tName;
        this.mClass = mClass;
        this.myTemp = myTemp;
        this.faTemp = faTemp;
        this.moTemp = moTemp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettDate() {
        return tDate;
    }

    public void settDate(String tDate) {
        this.tDate = tDate;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
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

    @Override
    public String toString() {
        return "Temp{" +
                "id=" + id +
                ", tDate='" + tDate + '\'' +
                ", tName='" + tName + '\'' +
                ", mClass='" + mClass + '\'' +
                ", myTemp=" + myTemp +
                ", faTemp=" + faTemp +
                ", moTemp=" + moTemp +
                '}';
    }
}
