package com.dds.designpattern.adapter;

/**
 * 顺丰快递寄件具体实现类
 */
public class SfExpressImpl implements SfExpress {
    @Override
    public void ship() {
        System.out.println("顺丰快递寄件");
    }

    @Override
    public void route() {
        System.out.println("顺丰快递查询包裹");
    }
}
