/*
 * module: fundermental
 * file: Combiner.java
 * date: 4/15/19 8:35 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-15 08:35
 * @desc test of generic with strategy pattern
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public interface Combiner<T> {
    T combine(T x,T y);
}

