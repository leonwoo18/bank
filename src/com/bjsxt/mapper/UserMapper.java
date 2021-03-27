package com.bjsxt.mapper;

import com.bjsxt.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //根据用户名和密码获取用户信息
    @Select("select * from t_user where uname=#{uname} and pwd=#{pwd}")
    User userLoginMapper(@Param("uname") String uname, @Param("pwd") String pwd);
}
