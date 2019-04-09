/*
 * module: fundermental
 * file: IntegerFactory.java
 * date: 4/9/19 8:45 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 08:45
 * @desc instantation
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric.betterfactory;

public class IntegerFactory implements Factory<Integer>{

    @Override
    public Integer create() {
        return new Integer(0);
    }
}

