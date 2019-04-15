/*
 * module: fundermental
 * file: UnaryFunction.java
 * date: 4/15/19 8:36 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-15 08:36
 * @desc test of generic with strategy pattern
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public interface UnaryFunction<R,T> {
    R function(T x);
}



