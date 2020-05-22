package com.example.demo.controller;

/*
@aothor cuiwanhzi
@date 2020/5/6
*/

import com.example.demo.entity.StuGrade;
import com.example.demo.mapper.StuGradeDownloads;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StuGradeDownloadsController {
    @Autowired
    StuGradeDownloads stuGradeDownloads;
    @RequestMapping(value = "StuGradeDownloadsController", method = RequestMethod.GET)


    public String downloadAllClassmate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        try{
            if (session.getAttribute("userID") !=null || session.getAttribute("userID").equals("root")) {

            }else {
                return "teaLogin";
            }
        }catch (Exception e){
            return "userLogin";
        }
        HSSFWorkbook  workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");

        List<StuGrade> classmateList = stuGradeDownloads.StuGrade();
        SimpleDateFormat dateFormat_min=new SimpleDateFormat("YYYY-MM-dd HH:mm");
        Date date=new Date();
        System.out.println(dateFormat_min.format(date));
        String s =dateFormat_min.format(date);

        String substr1 = s.substring(0,13);
        String substr2 = s.substring(14);
        String fileName = s+ ".xls";//设置要导出的文件的名字
        System.out.println(fileName);
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = { "id", "学号", "姓名", "成绩"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        if(classmateList != null)
            for (StuGrade stuGrade : classmateList) {
                HSSFRow row1 = sheet.createRow(rowNum);
                row1.createCell(0).setCellValue(stuGrade.getId());
                row1.createCell(1).setCellValue(stuGrade.getStuID());
                row1.createCell(2).setCellValue(stuGrade.getStuName());
                row1.createCell(3).setCellValue(stuGrade.getGrade());
                rowNum++;
            }


        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());

        return "teacherindex";
    }


}
