package com.dds.designpattern.proxy.dynamicproxy.refactoring;

public class UserDao implements IDao {

    @Override
    public Object getUser() {
        //重构前在业务类的方面里面调用
        //System.out.println("开始记录了日志");
        Object result = "1";
        //重构前在业务类的方面里面调用
        //System.out.println("结束记录了日志");
        return  result;
    }
}
