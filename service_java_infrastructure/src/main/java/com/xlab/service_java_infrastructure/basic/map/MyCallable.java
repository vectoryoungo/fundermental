/*
 * module: fundermental
 * file: MyCallable.java
 * date: 9/4/19 5:38 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-04 17:38
 * @desc this is my callable
 **/
package com.xlab.service_java_infrastructure.basic.map;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Object> {

    private String info;

    public MyCallable(String info) {
        this.info = info;
        System.out.println("MyCallable " + info);
    }

    @Override
    public Object call() throws Exception {
        System.out.println(" call() has been called ");
        return info;
    }
}

