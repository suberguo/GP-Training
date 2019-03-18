package com.dds.designpattern.template;

public class ExternalEcn extends Ecn {

    @Override
    public void initiate() {
        System.out.println("外部AE发起");
    }

    @Override
    protected boolean needReview() {
        return true;
    }
}
