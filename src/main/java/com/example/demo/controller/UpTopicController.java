package com.example.demo.controller;/*
@aothor cuiwanhzi
@date 2020/5/3
*/



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


//<span th:text="${tip}"></span>
@Controller
public class UpTopicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpTopicController.class);

    @GetMapping("/UpTopicController")
    public String upload() {
        return "UpTopicController";
    }

    @PostMapping("/UpTopicController")

    public String upload(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        try{
            if (session.getAttribute("userID") !=null || session.getAttribute("userID").equals("root")) {

                System.out.println(file.getOriginalFilename());
                if (file.isEmpty()) {
                    model.addAttribute("tip","文件不存在");
                    return "UpTopic";
                }
                String filePath = null;

                String fileName = file.getOriginalFilename();
                File directory = new File("");//设定为当前文件夹
                try{
                    System.out.println(directory.getCanonicalPath());//获取标准的路径
                    System.out.println(directory.getAbsolutePath());//获取绝对路径
                    filePath = directory.getAbsolutePath();
                }catch( IOException e){
                    model.addAttribute("tip","获取不到当前路径");
                    return "UpTopic";
                }
                String[] strs = fileName.toString().split("[.]");
                String[] fileNames = fileName.split("\\\\");
                fileName = fileNames[fileNames.length-1];
                System.out.println(fileName);
                if (!strs[strs.length-1].equals("txt")){
                    model.addAttribute("tip","请上传后缀为txt的文件");
                    return "UpTopic";

                }
                filePath = filePath +"\\Topic\\"+fileName;
                System.out.println(filePath);
                File dest = new File(filePath);

                try {
                    file.transferTo(dest);
                    LOGGER.info("上传成功");
                    model.addAttribute("tip","上传成功");
                    return "UpTopic";
                } catch (IOException e) {
                    LOGGER.error(e.toString(), e);
                }
                model.addAttribute("tip","上传失败，未知错误,建议检查题目内容");
                return "UpTopic";
            }
        }catch (Exception e){
            return "teaLogin";
        }

        return "teaLogin";

    }


}


