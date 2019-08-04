/*
 * module: fundermental
 * file: ConcreteDecoratorB.java
 * date: 8/4/19 4:58 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 16:57
 * @desc 实际的装饰器对象，实现具体要向被装饰对象添加的功能。
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter22;

public class ConcreteDecoratorB extends Decorator {

    private void addOperate() {
        //this is add operation
    }

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    public void operation() {
        //call super method
        super.operation();
        addOperate();
    }
}

