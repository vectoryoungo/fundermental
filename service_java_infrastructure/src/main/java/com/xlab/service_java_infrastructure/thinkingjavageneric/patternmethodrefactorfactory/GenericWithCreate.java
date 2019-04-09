/*
 * module: fundermental
 * file: GenericWithCreate.java
 * date: 4/9/19 9:20 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 09:20
 * @desc pattern method factory
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric.patternmethodrefactorfactory;

public abstract class GenericWithCreate<T> {

    final T element;

    abstract T create();

    GenericWithCreate() {
        element = create();
    }

}

