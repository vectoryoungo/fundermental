/*
 * module: fundermental
 * file: SelfBoundSetter.java
 * date: 4/10/19 4:46 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 16:46
 * @desc test of seltbound
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public interface SelfBoundSetter<T extends SelfBoundSetter<T>>{
    void set(T arg);
}

