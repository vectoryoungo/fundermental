/*
 * module: fundermental
 * file: SelfBounded.java
 * date: 4/10/19 4:18 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 16:17
 * @desc test of self generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class SelfBounded<T extends SelfBounded<T>> {

    T element;
    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

