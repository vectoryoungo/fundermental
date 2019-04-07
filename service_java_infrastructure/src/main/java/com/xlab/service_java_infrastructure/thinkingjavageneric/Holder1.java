/*
 * module: fundermental
 * file: Holder1.java
 * date: 4/7/19 5:35 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-07 17:35
 * @desc test of generic example
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class Holder1 {

    private Automobile automobile;
    public Holder1(Automobile automobile) {
        this.automobile = automobile;
    }

    Automobile get() {
        return automobile;
    }
}

