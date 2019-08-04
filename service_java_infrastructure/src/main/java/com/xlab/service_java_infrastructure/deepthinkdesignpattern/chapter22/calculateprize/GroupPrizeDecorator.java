/*
 * module: fundermental
 * file: GroupPrizeDecorator.java
 * date: 8/4/19 5:28 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 17:27
 * @desc 装饰器对象，计算当月团队的业务奖金
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter22.calculateprize;

import java.util.Date;

public class GroupPrizeDecorator extends Decorator{

    public GroupPrizeDecorator(Component component) {
        super(component);
    }

    @Override
    public double calculatePrize(String user, Date begin, Date end) {
        //step one:get previous prize
        double basic = super.calculatePrize(user, begin, end);
        //step two:calculate this month group prize
        double group = 0.0;
        for (double d:SimulatorPrizeContainer.prizeHolder.values()) {
            group +=d;
        }

        double prize = group * 0.01;
        System.out.println(user+" group prize " +prize);

        return basic+prize;
    }
}

