package com.dds.designpattern.singleton.lazy;

public class DoubleCheckLazyCEO {

    private static DoubleCheckLazyCEO INSTANCE = null;

    private DoubleCheckLazyCEO(String name) {
        this.name = name;
    }

    private String name = "张三";

    public String getName() {
        return name;
    }

    public static final DoubleCheckLazyCEO getInstance() {
        synchronized (DoubleCheckLazyCEO.class) {
            if (INSTANCE == null)
                INSTANCE = new DoubleCheckLazyCEO("张三");
        }
        return INSTANCE;
    }
}
