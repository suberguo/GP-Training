package com.dds.designpattern.strategy;

/**
 * 申请单
 */
public class ApplyOrder {

    private int applyUserId; // 申请人
    private String mcu;      //分部
    private String bu;       //业务线

    public int getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(int applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getMcu() {
        return mcu;
    }

    public void setMcu(String mcu) {
        this.mcu = mcu;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }
}
