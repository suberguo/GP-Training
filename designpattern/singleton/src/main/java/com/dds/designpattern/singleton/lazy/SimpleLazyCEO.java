package com.dds.designpattern.singleton.lazy;

public class SimpleLazyCEO {
    private static  SimpleLazyCEO INSTANCE = null;

    private SimpleLazyCEO(String name) {
        this.name = name;
    }

    private String name = "张三";

    public String getName() {
        return name;
    }

    public synchronized static final SimpleLazyCEO getInstance() {
        if(INSTANCE == null)
            INSTANCE = new SimpleLazyCEO("张三");
        return INSTANCE;
    }
}
