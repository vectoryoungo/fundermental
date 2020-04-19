/*
 * module: fundermental
 * file: WeakReferenceConcurrent.java
 * date: 4/19/20 6:00 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-19 17:59
 * @desc test weak reference use case
 * ThreadLocal 有什么用？Spring的Transactional事务，为了保证事务特性，比如A方法调用B方法，要保证事务必须两个是一个connection
 * 利用ThreadLocal来保证每个线程都有自己的connection。
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

