/*
 * module: fundermental
 * file: BeLoadedClass.java
 * date: 2/27/20 8:37 PM
 * author: VectorJu
 */

/**
 * @create 2020-02-27 20:37
 * @desc this demo is copy from https://segmentfault.com/a/1190000013469223 author is :林舍
 **/
package com.xlab.service_java_infrastructure.customerclassloader;

public class BeLoadedClass {

    public void say() {
        System.out.println("I'm Loaded by " + this.getClass().getClassLoader());
    }
}

