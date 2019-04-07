/*
 * module: fundermental
 * file: ImplA.java
 * date: 4/7/19 9:56 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-07 09:55
 * @desc implementation of Api
 **/
package com.xlab.service_java_infrastructure.deepthinkgof.refactor;

public class ImplA implements Api{
    @Override
    public void operation(String s) {
        System.out.println("ImplA s== " + s);
    }
}

