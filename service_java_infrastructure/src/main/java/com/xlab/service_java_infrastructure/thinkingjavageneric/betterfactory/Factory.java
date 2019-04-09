/*
 * module: fundermental
 * file: Factory.java
 * date: 4/9/19 8:43 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 08:42
 * @desc reveal factory
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric.betterfactory;

public interface Factory<T> {
    T create();
}

