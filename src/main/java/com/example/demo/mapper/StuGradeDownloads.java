package com.example.demo.mapper;/*
@aothor cuiwanhzi
@date 2020/5/6
*/

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.StuGrade;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface StuGradeDownloads {
    //mapper接口代码
    @Select("select * from tb_stuGrade")
    public List<StuGrade> StuGrade() ;




}
