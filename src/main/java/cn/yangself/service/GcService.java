package cn.yangself.service;

import cn.yangself.dao.GcDao;
import cn.yangself.domain.ClassResult;
import cn.yangself.domain.Result;
import cn.yangself.domain.Student;
import cn.yangself.domain.Temp;

import java.io.IOException;
import java.util.List;

public class GcService {
    private GcDao gcDao;
    public void setGcDao(GcDao gcDao) {
        this.gcDao = gcDao;
    }

    public Temp findByNameFromTemp(String tName, String mClass) throws IOException {
        //进行查询，查询所有数据
        return gcDao.findByNameFromTemp(tName, mClass);
    }

    public Student findByNameFromStudent(String sName, String mClass) throws IOException {
        return gcDao.findByNameFromStudent(sName, mClass);
    }

    public Temp findByNameFromTempToday(String tName, String mClass, String tDate) throws IOException {
        return gcDao.findByNameFromTempToday(tName, mClass, tDate);
    }

    public void addTemp(Temp temp) throws IOException {
        gcDao.addTemp(temp);
    }


    public void alterTemp(Temp temp) throws IOException {
        gcDao.alterTemp(temp);
    }

    public List<Result> getDayTemp(String tDate) throws IOException {
        return gcDao.getDayTemp(tDate);
    }

    public List<ClassResult> getDayTempList(String tDate,String mClass) throws IOException {
        return gcDao.getDayTempList(tDate, mClass);
    }

}
