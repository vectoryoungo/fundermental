/*
 * module: fundermental
 * file: CalculatePrize.java
 * date: 8/4/19 5:43 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 17:43
 * @desc calculate prize enter
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter22.calculateprize;

public class CalculatePrize {

    public static void main(String[] args) {
        Component basicComponent = new ConcreteComponent();

        Decorator month = new MonthPrizeDecorator(basicComponent);
        Decorator sum = new SumPrizeDecorator(month);

        double tomPrize = sum.calculatePrize("Tom",null,null);
        System.out.println(" tom sum prize is " + tomPrize);
        double triumphPrize = sum.calculatePrize("Triumph",null,null);
        System.out.println(" triumph sum prize is " + triumphPrize);

        Decorator manager = new GroupPrizeDecorator(sum);
        double johnPrize = manager.calculatePrize("John",null,null);
        System.out.println(" jon prize is " + johnPrize);
    }
}

