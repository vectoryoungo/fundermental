/*
 * module: fundermental
 * file: Customer.java
 * date: 4/8/19 5:46 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-08 17:46
 * @desc test of generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class Customer {

    private static long counter = 1;
    private final long id = counter++;

    private Customer() {}

    @Override
    public String toString() {
        return "customer " + id;
    }

    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

