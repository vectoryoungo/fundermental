/*
 * module: fundermental
 * file: ConcreteElementA.java
 * date: 8/8/19 11:33 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 11:33
 * @desc 具体元素对象，对象结构中具体的对象，也是被访问的对象，通常会回调访问者的真实功能，同时开放自身的数据供访问者使用。
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25;

public class ConcreteElementA extends Element{


    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }

    public void operation() {
        //already implement function
    }
}

