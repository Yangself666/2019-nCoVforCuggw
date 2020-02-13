package cn.yangself.domain;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer sid;
    private String sName;
    private String part;
    private String grade;
    private String major;
    private String sClass;
    private String addr;
    private String myTel;
    private String otTel;

    public Student() {
    }

    public Student(Integer sid, String sName, String part, String grade, String major, String sClass, String addr, String myTel, String otTel) {
        this.sid = sid;
        this.sName = sName;
        this.part = part;
        this.grade = grade;
        this.major = major;
        this.sClass = sClass;
        this.addr = addr;
        this.myTel = myTel;
        this.otTel = otTel;
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

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sName='" + sName + '\'' +
                ", part='" + part + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", sClass='" + sClass + '\'' +
                ", addr='" + addr + '\'' +
                ", myTel='" + myTel + '\'' +
                ", otTel='" + otTel + '\'' +
                '}';
    }
}
