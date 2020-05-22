package com.example.demo.controller;


import com.example.demo.mapper.StuGradeMapper;
import com.example.demo.sevice.MyInetAddress;
import com.example.demo.sevice.dateChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;

import java.util.ArrayList;

import java.util.List;


@Controller
public class teaController {
    public static ArrayList<List> list=new ArrayList();
    public static ArrayList finalQueList=new ArrayList();
    public static int  testTime;
    @Autowired
    MyInetAddress ip;

    @Autowired
    StuGradeMapper stuGradeMapper;

    @RequestMapping("/teapublish")
    public String publish(Model model, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        try{
            if (session.getAttribute("userID") !=null || session.getAttribute("userID").equals("root")) {
                stuGradeMapper.DeleteGetStu();
                list.clear();
                finalQueList.clear();

                File directory = new File("");
                File path1=new File(directory.getAbsolutePath());
                File file=new File(path1.getPath()+"\\Topic");
                System.out.println(path1.getPath()+"\\Topic");
                File[] files=file.listFiles();
                int tip=1;
                for(File f:files){


                    InputStreamReader isr = new InputStreamReader(new FileInputStream(f.getAbsolutePath()),"utf-8");


                    BufferedReader br=new BufferedReader(isr);
                    String str1;
                    List arr=new ArrayList();
                    arr.add("测试题库"+tip);
                    while((str1=br.readLine())!=null){
                        byte[] bytesLs = str1.getBytes("utf-8");

                        arr.add(new String(bytesLs,0,bytesLs.length,"utf-8"));

                    }

                    list.add(arr);
                    tip++;
                }
                model.addAttribute("testLs",list);
                return "publish";
            }
        }catch (Exception e){
            return "teaLogin";
        }
        return "teaLogin";

    }

    @RequestMapping("/teaSelectQues")
    public String getSelectQues(String quesTip,Model model,String[] timeList, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        try{
            if (session.getAttribute("userID") !=null || session.getAttribute("userID").equals("root")) {
                testTime=dateChange.dateListTo(timeList);
                for (int i=0;i<list.size();i++){
                    if(list.get(i).get(0).equals(quesTip)){
                        finalQueList.add(list.get(i));
                        model.addAttribute("finalQues",finalQueList);
                        model.addAttribute("timeList",testTime);
                        break;
                    }
                }
                if(finalQueList.size()==0){
                    finalQueList.add("");
                }
                finalQueList.add(testTime);
                finalQueList.add(ip.getUrl());
                return "redirect:/TeaTimer";
            }
        }catch (Exception e){
            return "teaLogin";
        }
        return "teaLogin";

    }



}
