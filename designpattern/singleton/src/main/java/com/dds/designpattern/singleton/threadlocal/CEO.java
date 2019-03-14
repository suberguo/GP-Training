package com.dds.designpattern.singleton.threadlocal;

public class CEO {
    private static final  ThreadLocal<CEO> threadLocal = new ThreadLocal<>();

    static {

    }

    public CEO getInstance(){
        return threadLocal.get();
    }
}
