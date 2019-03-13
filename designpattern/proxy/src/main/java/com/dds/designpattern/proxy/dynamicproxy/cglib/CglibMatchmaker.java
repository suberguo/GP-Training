package com.dds.designpattern.proxy.dynamicproxy.cglib;

import com.dds.designpattern.proxy.Person;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMatchmaker {

    private Class<?> target;

    public CglibMatchmaker(Class<?> clazz) {
        this.target = clazz;
    }

    public <T> T getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return methodProxy.invokeSuper(o,objects);
            }
        });
        T t = (T) enhancer.create();
        return t;
    }
}
