/*
 * module: fundermental
 * file: A.java
 * date: 18-6-29 上午9:24
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-29 09:24
 * @desc test A
 **/
package com.xlab.service_java_infrastructure.java8chapter9;

public interface A {
    default void hello(){
        System.out.println("Hello from A");
    }
}

