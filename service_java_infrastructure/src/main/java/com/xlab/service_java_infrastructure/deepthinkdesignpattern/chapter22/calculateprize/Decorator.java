/*
 * module: fundermental
 * file: Decorator.java
 * date: 8/4/19 5:12 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 17:11
 * @desc 装饰器接口，需要和被装饰的对象实现同样的接口
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter22.calculateprize;

import java.util.Date;

public abstract class Decorator extends Component{

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public double calculatePrize(String user, Date begin, Date end) {

        return component.calculatePrize(user,begin,end);
    }
}

