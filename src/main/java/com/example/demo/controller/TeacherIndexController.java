package com.example.demo.controller;/*
@aothor cuiwanhzi
@date 2020/5/10
*/


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TeacherIndexController {

    @RequestMapping("/TeacherIndexController/{path}")

    public String controller(@PathVariable("path") String path,HttpServletRequest request) {
        HttpSession session = request.getSession();
        try{
            if (session.getAttribute("userID") !=null || session.getAttribute("userID").equals("root")) {
                return "redirect:/" + path;
            }
        }catch (Exception e){
            return "teaLogin";
        }

        return "teaLogin";

    }
}
