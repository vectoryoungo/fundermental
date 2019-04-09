/*
 * module: fundermental
 * file: Solid2.java
 * date: 4/9/19 3:24 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 15:23
 * @desc test of generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T>{

    Solid2(T item) {
        super(item);
    }

    int weight(){
        return item.weight();
    }
}

