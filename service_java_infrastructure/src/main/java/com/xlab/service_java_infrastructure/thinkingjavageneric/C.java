/*
 * module: fundermental
 * file: C.java
 * date: 4/10/19 4:21 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 16:20
 * @desc test of selfbound
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class C extends SelfBounded<C>{
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

