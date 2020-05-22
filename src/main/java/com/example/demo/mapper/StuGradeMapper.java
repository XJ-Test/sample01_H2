package com.example.demo.mapper;

import com.example.demo.entity.StuGrade;

import org.apache.ibatis.annotations.*;

@Mapper
public interface StuGradeMapper {

    @Select("delete from tb_stuGrade ")
    public Void DeleteGetStu ();


    @Select("select * from tb_stuGrade where stuID=#{id}")
    public StuGrade getStu(String id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into tb_stuGrade(stuID,stuName) values(#{stuID},#{stuName})")
    public int insertStu(StuGrade stuGrade);

    @Update("update tb_stuGrade set grade=#{grade} where stuID=#{stuID}")
    public int insertStuGrade(StuGrade stuGrade);



}
