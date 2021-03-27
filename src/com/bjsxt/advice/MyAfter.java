package com.bjsxt.advice;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        //获取Log4j的对象
        Logger logger = Logger.getLogger(MyAfter.class);
        //日志输出
        if(o!=null){
            logger.debug(objects[0]+"登录成功");
        }

    }
}
