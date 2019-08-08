/*
 * module: fundermental
 * file: ConCreteElementB.java
 * date: 8/8/19 11:40 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 11:40
 * @desc concreteElementB
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25;

public class ConCreteElementB extends Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }

    public void operationB() {
        //already implement function
        System.out.println(" operationB ");
    }
}

