package com.dds.designpattern.proxy.dynamicproxy.custome;

import java.lang.reflect.Method;

public interface DdsInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
