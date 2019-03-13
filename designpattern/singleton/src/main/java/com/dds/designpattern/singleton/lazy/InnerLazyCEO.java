package com.dds.designpattern.singleton.lazy;

public class InnerLazyCEO {

    private InnerLazyCEO() {

    }

    public static final CEO getInstance() {
        return CEO.INSTANCE;
    }

    private static class CEO {
        private static final CEO INSTANCE = new CEO();
    }
}
