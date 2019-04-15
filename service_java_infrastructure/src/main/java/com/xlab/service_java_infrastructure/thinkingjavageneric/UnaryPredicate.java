/*
 * module: fundermental
 * file: UnaryPredicate.java
 * date: 4/15/19 8:39 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-15 08:38
 * @desc test of generic with strategy pattern
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public interface UnaryPredicate<T> {
    boolean test(T x);
}

