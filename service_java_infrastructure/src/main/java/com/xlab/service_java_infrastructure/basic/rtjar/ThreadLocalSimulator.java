/*
 * module: fundermental
 * file: ThreadLocalSimulator.java
 * date: 10/5/19 12:09 PM
 * author: VectorJu
 */

/**
 * @create 2019-10-05 12:09
 * @desc use case of ThreadLocal
 **/
/**
 * Do Not Use ThreadLocal with ExecutorService
 * If we want to use an ExecutorService and submit a Runnable to it, using ThreadLocal will yield non-deterministic results
 * because we do not have a guarantee that every Runnable action for a given userId will be handled by the same thread every time it is executed.
 * Because of that, our ThreadLocal will be shared among different userIds.
 * That's why we should not use a TheadLocal together with ExecutorService.
 * It should only be used when we have full control over which thread will pick which runnable action to execute.
 */
package com.xlab.service_java_infrastructure.basic.rtjar;

public class ThreadLocalSimulator {

    public static void main(String[] args) {



    }
}

