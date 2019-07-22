package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter17;

//计算优惠价格的策略接口
public interface PriceStrategy {

    /**
     * 计算应该的报价
     *
     */

    public double calcPrice(double goodPrice);
}
