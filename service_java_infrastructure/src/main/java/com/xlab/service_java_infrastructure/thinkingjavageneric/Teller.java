/*
 * module: fundermental
 * file: Teller.java
 * date: 4/8/19 5:50 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-08 17:49
 * @desc test of generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class Teller {

    private static long counter = 0;
    private final long id = counter++;

    private Teller() {}

    @Override
    public String toString() {
        return "Teller " + id;
    }

    public static Generator<Teller> generator() {
        return new Generator<Teller>() {
            @Override
            public Teller next() {
                return new Teller();
            }
        };
    }
}

