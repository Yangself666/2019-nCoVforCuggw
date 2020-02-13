package cn.yangself.service;

import cn.yangself.dao.GCDao;
import cn.yangself.domain.Result;
import cn.yangself.domain.Student;
import cn.yangself.domain.Temp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class GCService {
    public Temp findByNameFromTemp(String tName, String mClass) throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取到代理对象
        GCDao dao = sqlSession.getMapper(GCDao.class);
        //进行查询，查询所有数据
        Temp temp = dao.findByNameFromTemp(tName, mClass);
        return temp;
    }

    public Student findByNameFromStudent(String sName, String mClass) throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取到代理对象
        GCDao dao = sqlSession.getMapper(GCDao.class);
        //进行查询，查询所有数据
        Student student = dao.findByNameFromStudent(sName, mClass);
        return student;
    }

    public Temp findByNameFromTempToday(String tName, String mClass, String tDate) throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取到代理对象
        GCDao dao = sqlSession.getMapper(GCDao.class);
        //进行查询，查询所有数据
        Temp temp = dao.findByNameFromTempToday(tName, mClass, tDate);
        return temp;
    }

    public void addTemp(Temp temp) throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取到代理对象
        GCDao dao = sqlSession.getMapper(GCDao.class);
        dao.addTemp(temp);
        sqlSession.commit();
        sqlSession.close();
    }


    public void alterTemp(Temp temp) throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取到代理对象
        GCDao dao = sqlSession.getMapper(GCDao.class);
        dao.alterTemp(temp);
        sqlSession.commit();
        sqlSession.close();
    }

    public List<Result> getDayTemp(String tDate) throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取到代理对象
        GCDao dao = sqlSession.getMapper(GCDao.class);
        //进行查询，查询所有数据
        List<Result> result = dao.getDayTemp(tDate);
        return result;
    }

}
