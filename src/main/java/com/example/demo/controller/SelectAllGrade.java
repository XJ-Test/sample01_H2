package com.example.demo.controller;/*
@aothor cuiwanhzi
@date 2020/5/11
*/

import com.example.demo.entity.StuGrade;
import com.example.demo.mapper.StuGradeDownloads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SelectAllGrade {
    @Autowired
    StuGradeDownloads stuGradeDownloads;

    @RequestMapping("/SelectAllGrade")
    public String select(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        try{
            if (session.getAttribute("userID") !=null || session.getAttribute("userID").equals("root")) {
                List<StuGrade> grades = stuGradeDownloads.StuGrade();
                model.addAttribute("grades",grades);
                return "SelectGrade";
            }
        }catch (Exception e){
            return "teaLogin";
        }
        return "teaLogin";
    }
}
