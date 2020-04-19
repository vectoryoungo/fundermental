/*
 * module: fundermental
 * file: WeakReferenceConcurrent.java
 * date: 4/19/20 6:00 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-19 17:59
 * @desc test weak reference use case
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.lang.ref.WeakReference;

public class WeakReferenceConcurrent {

    public static void main(String[] args) {
        WeakReference<Weak> weakWeakReferenceConcurrent = new WeakReference(new Weak());
        System.out.println(weakWeakReferenceConcurrent.get());
        System.gc();
        System.out.println(weakWeakReferenceConcurrent.get());
        ThreadLocal<Weak> weakThreadLocal = new ThreadLocal<>();
        weakThreadLocal.set(new Weak());
        weakThreadLocal.remove();
    }
}

