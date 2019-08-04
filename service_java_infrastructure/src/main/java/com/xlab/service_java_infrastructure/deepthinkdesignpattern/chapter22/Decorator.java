/*
 * module: fundermental
 * file: Decorator.java
 * date: 8/4/19 4:53 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 16:52
 * @desc 所有装饰器的抽象父类，需要定义一个与组件接口一致的接口，并持有一个Component对象，其实就是持有一个被装饰得对象
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter22;

public abstract class Decorator extends Component {

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}

