package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Raymond
 * @create 2020-05-04-23:00
 */
@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;
    //获取用户信息
    public User getUser(String userID){
        return userMapper.getUser(userID);
    }
    //校对密码是否正确
    public boolean checkPwd(String userID,String userPwd){
        User tempUser = getUser(userID);
        if (tempUser.getUserPwd().equals(userPwd))
            return true;
        else
            return false;
    }
    //验证输入两次新密码是否一致
    public boolean consistentPwd(String newPwd,String surePwd){
        if (newPwd.equals(surePwd))
            return true;
        else
            return false;
    }
    //登录
    @RequestMapping("/userLogin")
    public String userLogin(String userID, String userPwd, HttpServletRequest request, Map<String,Object> map){
        if (getUser(userID)!=null){
            if (checkPwd(userID,userPwd)){
                HttpSession session = request.getSession();
                session.setAttribute("userID",userID);
                return "teacherindex";
            }else{
                map.put("msg","账号密码错误！");
                return "teaLogin";
            }
        }else{
            map.put("msg","用户不存在！");
            return "teaLogin";
        }
    }
    //更改密码
    @PostMapping("/userUpdatePwd")
    public String userUpdatePwd(String userID,String userPwd,String newPwd,String surePwd,Map<String,Object> map,HttpServletRequest request) {
        HttpSession session = request.getSession();
        try{
            if (session.getAttribute("userID") !=null || session.getAttribute("userID").equals("root")) {
                //1、判断输入的值是否为空
                if (userID.equals("") || userPwd.equals("") || newPwd.equals("") || surePwd.equals("")){
                    System.out.println("不能输入空值");
                    map.put("msg","不能输入空值！");
                    return "userChangePwd";
                }else{
                    //2、验证当前用户密码是否正确
                    if (checkPwd(userID,userPwd)){
                        //3、验证两次密码是否一致
                        if(consistentPwd(newPwd, surePwd)) {
                            User userTemp = new User();
                            userTemp.setUserID(userID);
                            userTemp.setUserPwd(newPwd);
                            if(userMapper.changeUserPassword(userTemp)!=0){
                                System.out.println("更改成功！");
                                map.put("msg","更改成功！");
                                return "TeacherIndex";
                            }else {
                                System.out.println("更新失败!");
                                map.put("msg","更改密码失败！");
                                return "userChangePwd";
                            }
                        }else{
                            System.out.println("两次密码不一致！");
                            map.put("msg","两次密码不一致！");
                            return "userChangePwd";
                        }
                    }else {
                        System.out.println("密码错误！");
                        map.put("msg","用户密码错误！");
                        return "userChangePwd";
                    }
                }
            }
        }catch (Exception e){
            map.put("msg","请先登录！");
            return "teaLogin";
        }
        map.put("msg","请先登录！");
        return "teaLogin";


    }
}
