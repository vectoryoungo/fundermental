/*
 * module: fundermental
 * file: ConcreteVisitorO.java
 * date: 8/8/19 11:43 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 11:42
 * @desc 具体的访问者实现对象，实现要真正被添加到对象结构中的功能。
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25;

public class ConcreteVisitorO implements Visitor {


    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        concreteElementA.operation();
    }

    @Override
    public void visitConcreteElementB(ConCreteElementB conCreteElementB) {
        conCreteElementB.operationB();
    }
}

