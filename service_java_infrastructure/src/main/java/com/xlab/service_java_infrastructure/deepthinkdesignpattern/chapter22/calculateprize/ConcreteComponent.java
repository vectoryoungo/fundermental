/*
 * module: fundermental
 * file: ConcreteComponent.java
 * date: 8/4/19 5:06 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 17:06
 * @desc 基本的实现计算奖金的类，也就是被装饰器装饰的对象
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter22.calculateprize;

import java.util.Date;

public class ConcreteComponent extends Component {

    @Override
    public double calculatePrize(String user, Date begin, Date end) {

        //default implement no prize
        return 0;
    }
}

