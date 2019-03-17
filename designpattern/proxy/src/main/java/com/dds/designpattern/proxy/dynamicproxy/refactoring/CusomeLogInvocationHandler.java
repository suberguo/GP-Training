package com.dds.designpattern.proxy.dynamicproxy.refactoring;

import com.dds.designpattern.proxy.dynamicproxy.custome.DdsInvocationHandler;

import java.lang.reflect.Method;

public class CusomeLogInvocationHandler implements DdsInvocationHandler {

    private Object object;

    public CusomeLogInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始记录了日志");
        Object result = method.invoke(this.object,args);
        System.out.println("结束记录了日志");
        return result;
    }
}
