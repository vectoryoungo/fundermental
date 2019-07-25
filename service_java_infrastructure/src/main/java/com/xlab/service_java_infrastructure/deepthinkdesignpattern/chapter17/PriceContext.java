package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter17;

//价格管理，主要实现向客户报价的功能
public class PriceContext {

    private PriceStrategy priceStrategy;

    public PriceContext(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    /**
     * 报价，计算对客户的报价
     * @param price
     * @return
     */
    public double quote(double price) {
        return this.priceStrategy.calcPrice(price);
    }
}
