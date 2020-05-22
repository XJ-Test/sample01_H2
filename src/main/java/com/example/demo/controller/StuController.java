package com.example.demo.controller;

import com.example.demo.entity.StuGrade;
import com.example.demo.mapper.StuGradeMapper;

import com.example.demo.sevice.dateChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
public class StuController {

//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    StuInfoRepository stuInfoRepository;
    @Autowired
    StuGradeMapper stuGradeMapper;


    @PostMapping("/stu")
    @ResponseBody
    public StuGrade insertGrade(@RequestBody StuGrade stuGrade){
//        StuGrade save=userRepository.save(stuGrade);
//        userRepository.updateStu(stuGrade.getGrade(),stuGrade.getStuID(),stuGrade.getStuName());

        stuGradeMapper.insertStuGrade(stuGrade);

        return stuGrade;
    }

    @PostMapping("/stuLogin")
    public String insertStu(StuGrade stuGrade, Model model) {
//        StuGrade save=userRepository.save(stuGrade);
        StuGrade s = stuGradeMapper.getStu(stuGrade.getStuID());
        if (s==null){
            System.out.println("null");
            stuGrade.setGrade((float) 0);
            stuGradeMapper.insertStu(stuGrade);

        }else if (s.getGrade()!=0){
            model.addAttribute("msg","您已经提交过了！");
            return "login";
        }
        model.addAttribute("stuID",stuGrade.getStuID());
        model.addAttribute("stuName",stuGrade.getStuName());
        model.addAttribute("testQues",teaController.finalQueList);
        if (dateChange.testTimeJudge > 0){
            stuGradeMapper.insertStuGrade(stuGrade);
            return "index";
        }else {
            model.addAttribute("msg","提交时间到了！");
            return "login";
        }




    }

/*    @RequestMapping("/stuMy/{id}")
    @ResponseBody
    public StuGrade getStuGradeMy(@PathVariable("id") Integer id,, HttpServletRequest request){
        HttpSession session = request.getSession();

        return stuGradeMapper.getStuGrade(id);
    }*/

    @RequestMapping("/stuQues")
    @ResponseBody
    public List getQues(){
//        dateChange.dateCurrent();
        dateChange d=new dateChange();
        d.dateCurrent();
        return teaController.finalQueList;
    }

}
