package com.dds.designpattern.adapter;

/**
 * 联邦快递适配器
 * 随着公司业务规模扩大，现在平台业务全面转向国际市场
 * 后续所有商品将全部使用联邦快递寄件
 * 为不修改打单系统原来代码特增加此适配器以兼容原有接口
 */
public class FedExAdapter implements SfExpress {

    private FedEx fedEx;

    public FedExAdapter(FedEx fedEx) {
        this.fedEx = fedEx;
    }

    @Override
    public void ship() {
       this.fedEx.send();
    }

    @Override
    public void route() {
       this.fedEx.tracking();
    }
}
