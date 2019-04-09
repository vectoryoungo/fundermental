/*
 * module: fundermental
 * file: Creator.java
 * date: 4/9/19 9:27 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 09:27
 * @desc test of generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric.patternmethodrefactorfactory;

public class Creator extends GenericWithCreate<X> {
    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
        System.out.println(element);
    }
}

