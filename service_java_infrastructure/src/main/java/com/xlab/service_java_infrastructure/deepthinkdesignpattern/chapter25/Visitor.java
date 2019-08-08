/*
 * module: fundermental
 * file: Visitor.java
 * date: 8/8/19 11:32 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 11:31
 * @desc 访问者接口，为所有的访问者对象声明一个visit方法，用来代表为对象结构添加的功能，理论上可以代表任意的功能。
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25;

public interface Visitor {

    public void visitConcreteElementA(ConcreteElementA concreteElementA);
    public void visitConcreteElementB(ConCreteElementB conCreteElementB);
}

