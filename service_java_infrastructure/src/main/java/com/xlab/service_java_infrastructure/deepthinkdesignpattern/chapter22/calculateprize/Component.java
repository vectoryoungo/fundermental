/*
 * module: fundermental
 * file: Component.java
 * date: 8/4/19 5:05 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 17:04
 * @desc 计算奖金的接口
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter22.calculateprize;

import java.util.Date;

public abstract class Component {

    public abstract double calculatePrize(String user, Date begin,Date end);
}

