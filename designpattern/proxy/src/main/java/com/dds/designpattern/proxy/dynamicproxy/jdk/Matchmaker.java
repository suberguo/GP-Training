package com.dds.designpattern.proxy.dynamicproxy.jdk;

import com.dds.designpattern.proxy.IPerson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Matchmaker implements InvocationHandler {

    private Object target;

    public Matchmaker(Object obj) {
        this.target = obj;
    }

    public void find() {
        IPerson person = (IPerson) Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
        System.out.println("媒婆帮忙找");
        person.findLove();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target, args);
    }

}
