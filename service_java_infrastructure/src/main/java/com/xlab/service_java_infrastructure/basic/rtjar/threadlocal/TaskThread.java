/*
 * module: fundermental
 * file: TaskThread.java
 * date: 10/6/19 9:38 AM
 * author: VectorJu
 */

/**
 * @create 2019-10-06 09:37
 * @desc TaskThread
 **/
package com.xlab.service_java_infrastructure.basic.rtjar.threadlocal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * Do Not Use ThreadLocal with ExecutorService
 * If we want to use an ExecutorService and submit a Runnable to it, using ThreadLocal will yield non-deterministic results
 * because we do not have a guarantee that every Runnable action for a given userId will be handled by the same thread every time it is executed.
 * Because of that, our ThreadLocal will be shared among different userIds.
 * That's why we should not use a ThreadLocal together with ExecutorService.
 * It should only be used when we have full control over which thread will pick which runnable action to execute.
 */
public class TaskThread<T> extends Thread {

    private T t;

    public TaskThread(String threadName,T t) {
        this.setName(threadName);
        this.t = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {

            try {
                Class[] argsClass = new Class[0];
                Method method = t.getClass().getMethod("getUniqueId",argsClass);
                int value = (int) method.invoke(t);
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> uniqueId["+value+ "]");

            } catch (NoSuchMethodException e) {
                // write log
                continue;

            } catch (IllegalAccessException e) {
                // write log
                continue;

            } catch (InvocationTargetException e) {
                // write log
                continue;

            }
        }
    }
}

