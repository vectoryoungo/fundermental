/*
 * module: fundermental
 * file: Client.java
 * date: 8/8/19 2:36 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 14:35
 * @desc test visitor client
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25;

public class Client {

    public static void main(String[] args) {
        //create ObjectStructure
        ObjectStructure objectStructure = new ObjectStructure();
        Element elementA = new ConcreteElementA();
        Element elementB = new ConCreteElementB();
        objectStructure.addElement(elementA);
        objectStructure.addElement(elementB);

        Visitor visitor = new ConcreteVisitorO();

        objectStructure.handleRequest(visitor);
    }

}

