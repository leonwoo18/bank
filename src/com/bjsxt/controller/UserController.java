package com.bjsxt.controller;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserController {
    //声明业务层属性
    @Autowired
    private UserService userService;
    //声明单元方法:处理登录请求
    @RequestMapping("userLogin")
    protected String userLogin(HttpServletRequest req) {
        //获取请求信息
            String uname=req.getParameter("uname");
            String pwd=req.getParameter("pwd");
        //处理请求
            //调用业务层方法根据用户名和密码获取用户信息
            User user = userService.userLoginService(uname, pwd);
        //响应处理结果
            //获取Session对象
             HttpSession session=req.getSession();
            //响应
            if(user!=null){
                 return "redirect:/main.jsp";
            }else{
                session.setAttribute("flag","userFail");
                return "redirect:/login.jsp";
            }
    }
}
