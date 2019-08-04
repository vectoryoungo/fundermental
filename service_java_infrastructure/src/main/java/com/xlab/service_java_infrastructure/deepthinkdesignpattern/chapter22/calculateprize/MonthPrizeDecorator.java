/*
 * module: fundermental
 * file: MonthPrizeDecorator.java
 * date: 8/4/19 5:15 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 17:15
 * @desc 装饰器对象，计算当月业务奖金
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter22.calculateprize;

import java.util.Date;

public class MonthPrizeDecorator extends Decorator{

    public MonthPrizeDecorator(Component component) {
        super(component);
    }

    @Override
    public double calculatePrize(String user, Date begin, Date end) {

        //step one:get prize from previous
        double basic = super.calculatePrize(user,begin,end);
        //step two:calculate this month prize,get business amount according to employee and time and multiply 3%
        double prize = SimulatorPrizeContainer.prizeHolder.get(user)*0.03;

        return basic+prize;
    }
}

