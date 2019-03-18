package com.dds.designpattern.adapter;

/**
 * 顺丰快递接口
 */

public interface SfExpress {

    /**
     * 寄件
     */
    void ship();

    /**
     * 包裹追踪
     */
    void route();

}
