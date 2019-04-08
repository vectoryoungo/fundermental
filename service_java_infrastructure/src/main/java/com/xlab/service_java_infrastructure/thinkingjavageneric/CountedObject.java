/*
 * module: fundermental
 * file: CountedObject.java
 * date: 4/8/19 8:19 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-08 08:18
 * @desc test how many object has been created
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class CountedObject {


    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject " + id;
    }
}

