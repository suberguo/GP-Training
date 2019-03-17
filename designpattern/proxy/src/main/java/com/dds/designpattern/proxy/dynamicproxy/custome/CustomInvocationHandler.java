package com.dds.designpattern.proxy.dynamicproxy.custome;

import com.dds.designpattern.proxy.IPerson;

import java.lang.reflect.Method;

public class CustomInvocationHandler implements DdsInvocationHandler {

    private IPerson person;

    public CustomInvocationHandler(IPerson person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.person, args);
    }
}
