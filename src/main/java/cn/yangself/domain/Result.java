package cn.yangself.domain;

import java.io.Serializable;

public class Result implements Serializable {
    private Integer sid;
    private String sName;
    private String part;
    private String grade;
    private String major;
    private String sClass;
    private String addr;
    private String myTel;
    private String otTel;
    private Double myTemp;
    private Double faTemp;
    private Double moTemp;

    public Result() {
    }

    public Result(Integer sid, String sName, String part, String grade, String major, String sClass, String addr, String myTel, String otTel, Double myTemp, Double faTemp, Double moTemp) {
        this.sid = sid;
        this.sName = sName;
        this.part = part;
        this.grade = grade;
        this.major = major;
        this.sClass = sClass;
        this.addr = addr;
        this.myTel = myTel;
        this.otTel = otTel;
        this.myTemp = myTemp;
        this.faTemp = faTemp;
        this.moTemp = moTemp;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMyTel() {
        return myTel;
    }

    public void setMyTel(String myTel) {
        this.myTel = myTel;
    }

    public String getOtTel() {
        return otTel;
    }

    public void setOtTel(String otTel) {
        this.otTel = otTel;
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
        return "Result{" +
                "sid=" + sid +
                ", sName='" + sName + '\'' +
                ", part='" + part + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", sClass='" + sClass + '\'' +
                ", addr='" + addr + '\'' +
                ", myTel='" + myTel + '\'' +
                ", otTel='" + otTel + '\'' +
                ", myTemp=" + myTemp +
                ", faTemp=" + faTemp +
                ", moTemp=" + moTemp +
                '}';
    }
}
