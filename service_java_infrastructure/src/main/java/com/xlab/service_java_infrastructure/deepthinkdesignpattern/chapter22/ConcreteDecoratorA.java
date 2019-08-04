/*
 * module: fundermental
 * file: ConcreteDecoratorA.java
 * date: 8/4/19 4:55 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 16:55
 * @desc 实际的装饰器对象，实现具体要向被装饰对象添加的功能
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter22;

public class ConcreteDecoratorA extends Decorator{

    private String addedState;

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    public void operation() {

        //here to process self define logic
        super.operation();
    }

    public String getAddedState() {
        return addedState;
    }

    public void setAddedState(String addedState) {
        this.addedState = addedState;
    }
}

