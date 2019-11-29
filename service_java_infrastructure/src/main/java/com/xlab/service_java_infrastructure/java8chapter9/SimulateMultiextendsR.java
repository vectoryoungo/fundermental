/*
 * module: fundermental
 * file: SimulateMultiextendsR.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: SimulateMultiextendsR.java
 * date: 18-6-29 上午9:07
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-29 09:07
 * @desc simulate multiextends
 **/
package com.xlab.service_java_infrastructure.java8chapter9;

public interface SimulateMultiextendsR {
    default void hello() {
        System.out.println("Hello from R ");
    }
}

