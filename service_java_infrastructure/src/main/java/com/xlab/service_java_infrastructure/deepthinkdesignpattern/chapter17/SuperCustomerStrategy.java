package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter17;

//大客户
public class SuperCustomerStrategy implements PriceStrategy {
    @Override
    public double calcPrice(double goodPrice) {

        System.out.println("super customer 10% profit ");
        return goodPrice*(1-0.1);
    }
}
