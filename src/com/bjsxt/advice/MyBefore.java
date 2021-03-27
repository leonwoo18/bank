package com.bjsxt.advice;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        //获取Log4j的对象
        Logger logger = Logger.getLogger(MyBefore.class);
        //日志输出
        logger.debug(objects[0]+"发起了登录请求");
    }
}
