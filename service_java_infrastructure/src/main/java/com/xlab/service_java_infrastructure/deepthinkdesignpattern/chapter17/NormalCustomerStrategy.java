package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter17;

//普通客户
public class NormalCustomerStrategy implements PriceStrategy {
    @Override
    public double calcPrice(double goodPrice) {
        System.out.println("normal customer no profit");
        return goodPrice;
    }
}
