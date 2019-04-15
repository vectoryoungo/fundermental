/*
 * module: fundermental
 * file: SelfBoundingAndCovariantArguments.java
 * date: 4/10/19 4:50 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 16:50
 * @desc test of selfbound
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class SelfBoundingAndCovariantArguments {

    void testA(Setter setter,Setter setter2,SelfBoundSetter selfBoundSetter) {
        setter.set(setter2);
        //setter.set(selfBoundSetter);this is illegal
    }
}

