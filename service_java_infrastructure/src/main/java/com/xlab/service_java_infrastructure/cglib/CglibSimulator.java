/*
 * module: fundermental
 * file: CglibSimulator.java
 * date: 2/28/20 2:40 PM
 * author: VectorJu
 */

/**
 * @create 2020-02-28 14:40
 * @desc
 **/
package com.xlab.service_java_infrastructure.cglib;

public class CglibSimulator {

    public static void main(String[] args) {
        AmericanProxy americanProxy = new AmericanProxy();
        American american = new American();
        American peter = (American) americanProxy.createProxy(american);
        peter.showHealth();
    }

}

