package com.bjsxt.controller;

import com.bjsxt.pojo.Account;
import com.bjsxt.service.CheckAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/checkAccount",loadOnStartup = 2)
public class CheckAccountServlet extends HttpServlet {
    //声明业务层属性
    private CheckAccountService checkAccountService;
   //重写init方法
    @Override
    public void init() throws ServletException {
        //获取Spring容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationcontext.xml");
        //获取业务层对象
        checkAccountService= (CheckAccountService) ac.getBean("checkAccountServiceImpl");
    }
    //重写service方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
            req.setCharacterEncoding("utf-8");
        //设置响应编码格式
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
         //获取请求数据中的方法名
        String methodName=req.getParameter("methodName");
        //根据请求调用对应的逻辑代码
        if("checkOutInfo".equals(methodName)){
            checkOutInfo(req,resp);
        }else if("checkMoneyInfo".equals(methodName)){
            checkMoneyInfo(req,resp);
        }else if("checInInfo".equals(methodName)){
            checInInfo(req,resp);
        }else if("transferInfo".equals(methodName)){
            transferInfo(req,resp);
        }else{
            System.out.println("没有对应的逻辑方法:"+methodName);
        }
    }

    //校验收款人信息
    private void checInInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求数据
            String inId=req.getParameter("inId");
            String inName=req.getParameter("inName");
        //处理请求
            Account account=checkAccountService.checkInInfoService(inId,inName);
        //响应结果
            resp.getWriter().write(account!=null?"true":"false");
    }
    //校验金额
    private void checkMoneyInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求数据
            String outId=req.getParameter("outId");
            String money =req.getParameter("money");
        //处理请求
            Account account=checkAccountService.checkMoneyInfoService(outId,money);
        //响应结果
            resp.getWriter().write(account!=null?"true":"false");
    }

    //校验转账账户信息
    private void checkOutInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求信息
        String outId=req.getParameter("outId");
        String outPwd=req.getParameter("outPwd");
        //处理请求
        //调用业务层方法
        Account account = checkAccountService.checkOutAccountInfoService(outId, outPwd);
        //响应结果
        resp.getWriter().write(account!=null?"true":"false");
    }


    //转账
    private void transferInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求数据
        String outId=req.getParameter("outId");
        String inId=req.getParameter("inId");
        String money=req.getParameter("money");
        //处理请求
        int i=checkAccountService.transferInfoService(outId,inId,money);
        //响应结果
        if(i>0){
            resp.sendRedirect(req.getContextPath()+"/success.jsp");
        }else{
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }
    }

}
