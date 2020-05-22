package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
/**
 * @author Raymond
 * @create 2020-05-04-22:52
 */
@Mapper
public interface UserMapper {
    @Select("select * from tb_user where userId=#{userId}")
    public User getUser(String userId);
    @Update("update tb_user set userPwd=#{userPwd} where userID=#{userID}")
    public int changeUserPassword(User user);
}
