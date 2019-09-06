/*
 * module: fundermental
 * file: OutOfMemorySimulator.java
 * date: 9/6/19 10:13 AM
 * author: VectorJu
 */

/**
 * @create 2019-09-06 10:13
 * @desc test of jvm out of memory
 **/
package com.xlab.service_java_infrastructure.basic.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class OutOfMemorySimulator {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object obj, Method method,
                                        Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {
    }
}

