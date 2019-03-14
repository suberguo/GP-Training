package com.dds.designpattern.singleton.lazy;

public class InnerLazyCEO {

    private InnerLazyCEO() throws Exception {
        if (CEO.INSTANCE != null) {
            throw new Exception("不能创建对象");
        }
    }

    public static final CEO getInstance() {
        return CEO.INSTANCE;
    }

    private static class CEO {
        private static final CEO INSTANCE = new CEO();
    }
}
