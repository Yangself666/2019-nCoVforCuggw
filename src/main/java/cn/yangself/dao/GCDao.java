package cn.yangself.dao;

import cn.yangself.domain.Result;
import cn.yangself.domain.Student;
import cn.yangself.domain.Temp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.io.IOException;
import java.util.List;

/**
 * 这是体温数据操作的接口
 */
public interface GCDao {
    /**
     * 从Temp表中按学生姓名和班级查询
     * @return
     * 返回一个带体温的实体类
     */
    @Select("select * from temp where tName = #{arg0} AND mClass = #{arg1};")
    Temp findByNameFromTemp(String tName,String mClass) throws IOException;

    /**
     * 从Student表中按学生姓名和班级查询
     * @return
     * 返回一个带体温的实体类
     */
    @Select("select * from student where sName = #{arg0} AND sClass = #{arg1};")
    Student findByNameFromStudent(String sName, String sClass);

    /**
     * 查询在temp表中有没有今天录入的信息
     * @param tName
     * @param mClass
     * @param tDate
     * @return
     * @throws IOException
     */
    @Select("select * from temp where tName = #{arg0} AND mClass = #{arg1} AND tDate = #{arg2};")
    Temp findByNameFromTempToday(String tName,String mClass,String tDate) throws IOException;

    /**
     * 将体温信息存入数据库
     * @param temp
     */
    @Insert("insert into temp (tDate,tName,mClass,myTemp,faTemp,moTemp) values (#{tDate},#{tName},#{mClass},#{myTemp},#{faTemp},#{moTemp})")
    void addTemp(Temp temp);

    /**
     * 修改已经拥有的数据
     * @param temp
     */
    @Update("UPDATE temp SET myTemp=#{myTemp}, faTemp=#{faTemp},moTemp=#{moTemp} WHERE tName = #{tName} AND mClass = #{mClass} AND tDate = #{tDate} ")
    void alterTemp(Temp temp);

    @Select("select sid,sName,part,grade,major,sClass,addr,myTel,otTel,myTemp,faTemp,moTemp from student left outer join temp on temp.tName = student.sName AND temp.tDate = #{arg1};")
    List<Result> getDayTemp(String tDate);
}
