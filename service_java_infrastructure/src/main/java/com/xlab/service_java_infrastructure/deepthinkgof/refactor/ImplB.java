/*
 * module: fundermental
 * file: ImplB.java
 * date: 4/7/19 9:58 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-07 09:58
 * @desc implementation of Api
 **/
package com.xlab.service_java_infrastructure.deepthinkgof.refactor;

public class ImplB  implements Api{
    @Override
    public void operation(String s) {
        System.out.println("ImplB s== " + s);
    }
}

