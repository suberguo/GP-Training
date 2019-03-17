package com.dds.designpattern.proxy.dynamicproxy.refactoring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {

    private IDao dao;

    public LogInvocationHandler(IDao dao) {
        this.dao = dao;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始记录了日志");
        Object result = method.invoke(this.dao,args);
        System.out.println("结束记录了日志");
        return result;
    }
}
