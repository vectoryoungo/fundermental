/*
 * module: fundermental
 * file: ConcreteComponent.java
 * date: 8/4/19 4:50 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 16:50
 * @desc 具体的组件对象，实现组件对象接口，通常就是被装饰器装饰的原始对象，也就是可以给这个对象添加职责。
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter22;

public class ConcreteComponent extends Component {
    @Override
    public void operation() {
        //specific operate
    }
}

