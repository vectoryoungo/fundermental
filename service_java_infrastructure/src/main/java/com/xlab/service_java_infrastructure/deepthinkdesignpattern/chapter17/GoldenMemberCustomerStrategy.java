package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter17;

//黄金会员
public class GoldenMemberCustomerStrategy implements PriceStrategy {
    @Override
    public double calcPrice(double goodPrice) {
        System.out.println("golden member customer 5% profit");
        return goodPrice*(1-0.05);
    }
}
