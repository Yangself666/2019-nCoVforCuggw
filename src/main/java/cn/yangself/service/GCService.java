package cn.yangself.service;

import cn.yangself.MybatisUtil;
import cn.yangself.dao.GCDao;
import cn.yangself.domain.ClassResult;
import cn.yangself.domain.Result;
import cn.yangself.domain.Student;
import cn.yangself.domain.Temp;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class GCService {
    public Temp findByNameFromTemp(String tName, String mClass) throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        GCDao dao = sqlSession.getMapper(GCDao.class);
        //进行查询，查询所有数据
        Temp temp = dao.findByNameFromTemp(tName, mClass);
        sqlSession.close();
        return temp;
    }

    public Student findByNameFromStudent(String sName, String mClass) throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //获取到代理对象
        GCDao dao = sqlSession.getMapper(GCDao.class);
        //进行查询，查询所有数据
        Student student = dao.findByNameFromStudent(sName, mClass);
        sqlSession.close();
        return student;
    }

    public Temp findByNameFromTempToday(String tName, String mClass, String tDate) throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //获取到代理对象
        GCDao dao = sqlSession.getMapper(GCDao.class);
        //进行查询，查询所有数据
        Temp temp = dao.findByNameFromTempToday(tName, mClass, tDate);
        sqlSession.close();
        return temp;
    }

    public void addTemp(Temp temp) throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //获取到代理对象
        GCDao dao = sqlSession.getMapper(GCDao.class);
        dao.addTemp(temp);
        sqlSession.commit();
        sqlSession.close();
    }


    public void alterTemp(Temp temp) throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //获取到代理对象
        GCDao dao = sqlSession.getMapper(GCDao.class);
        dao.alterTemp(temp);
        sqlSession.commit();
        sqlSession.close();
    }

    public List<Result> getDayTemp(String tDate) throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //获取到代理对象
        GCDao dao = sqlSession.getMapper(GCDao.class);
        //进行查询，查询所有数据
        List<Result> result = dao.getDayTemp(tDate);
        sqlSession.close();
        return result;
    }

    public List<ClassResult> getDayTempList(String tDate,String mClass) throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //获取到代理对象
        GCDao dao = sqlSession.getMapper(GCDao.class);
        //进行查询，查询所有数据
        List<ClassResult> ClassResult = dao.getDayTempList(tDate,mClass);
        sqlSession.close();
        return ClassResult;
    }

}
