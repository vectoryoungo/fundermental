/*
 * module: fundermental
 * file: B.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: B.java
 * date: 18-6-29 上午9:25
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-29 09:25
 * @desc test B
 **/
package com.xlab.service_java_infrastructure.java8chapter9;

public interface B extends A {
    default void hello(){
        System.out.println("Hello from B");
    }
}

