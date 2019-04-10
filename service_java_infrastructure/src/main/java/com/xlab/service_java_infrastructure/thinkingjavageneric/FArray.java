/*
 * module: fundermental
 * file: FArray.java
 * date: 4/10/19 3:02 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 15:02
 * @desc test of generic array
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class FArray {

    public static <T> T[] fill(T[] a,Generator<T> gen) {
        for (int i=0;i<a.length;i++) {
            a[i] = gen.next();
        }

        return a;
    }
}

