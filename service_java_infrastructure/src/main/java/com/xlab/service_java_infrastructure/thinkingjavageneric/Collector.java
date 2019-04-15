/*
 * module: fundermental
 * file: Collector.java
 * date: 4/15/19 8:37 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-15 08:37
 * @desc test of generic with strategy pattern
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public interface Collector<T> extends UnaryFunction<T,T> {
    T result();
}

