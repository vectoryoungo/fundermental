/*
 * module: fundermental
 * file: SumPrizeDecorator.java
 * date: 8/4/19 5:24 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 17:22
 * @desc 装饰器对象，计算累计奖金
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter22.calculateprize;

import java.util.Date;

public class SumPrizeDecorator extends Decorator {

    public SumPrizeDecorator(Component component) {
        super(component);
    }

    @Override
    public double calculatePrize(String user, Date begin, Date end) {
        //step one:get previous prize
        double basic = super.calculatePrize(user, begin, end);
        //step two:calculate sum prize
        double prize = 100000*0.001;
        System.out.println("user " + user +" sum prize " + prize);
        return basic+prize;
    }
}

