package com.bjsxt.service;

import com.bjsxt.pojo.User;

public interface UserService {
    //用户登录
    User userLoginService(String uname, String pwd);
}
