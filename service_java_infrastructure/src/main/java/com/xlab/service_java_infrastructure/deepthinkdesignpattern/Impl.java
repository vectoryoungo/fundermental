/*
 * module: fundermental
 * file: Impl.java
 * date: 4/7/19 9:43 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-07 09:42
 * @desc implementation of api
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern;

public class Impl implements Api{
    @Override
    public void test1(String s) {
        System.out.println("Now In Impl. The input s=="+s);
    }
}

