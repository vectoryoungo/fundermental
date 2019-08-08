/*
 * module: fundermental
 * file: ConcreteVisitorT.java
 * date: 8/8/19 2:35 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 14:35
 * @desc ConcreteVisitorT
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25;

public class ConcreteVisitorT implements Visitor{


    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        concreteElementA.operation();
    }

    @Override
    public void visitConcreteElementB(ConCreteElementB conCreteElementB) {
        conCreteElementB.operationB();
    }
}

