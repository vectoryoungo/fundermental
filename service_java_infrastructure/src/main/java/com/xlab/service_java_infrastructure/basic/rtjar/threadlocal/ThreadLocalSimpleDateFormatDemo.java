/*
 * module: fundermental
 * file: ThreadLocalSimpleDateFormateDemo.java
 * date: 10/6/19 10:16 AM
 * author: VectorJu
 */

/**
 * @create 2019-10-06 10:16
 * @desc
 **/
package com.xlab.service_java_infrastructure.basic.rtjar.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Do Not Use ThreadLocal with ExecutorService
 * If we want to use an ExecutorService and submit a Runnable to it, using ThreadLocal will yield non-deterministic results
 * because we do not have a guarantee that every Runnable action for a given userId will be handled by the same thread every time it is executed.
 * Because of that, our ThreadLocal will be shared among different userIds.
 * That's why we should not use a TheadLocal together with ExecutorService.
 * It should only be used when we have full control over which thread will pick which runnable action to execute.
 */
public class ThreadLocalSimpleDateFormatDemo implements Runnable {

    // threadlocal variable is created
    private static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue(){
            System.out.println("Initializing SimpleDateFormat for - " + Thread.currentThread().getName() );
            return new SimpleDateFormat("dd/MM/yyyy");
        }
    };

    public static void main(String[] args) {
        ThreadLocalSimpleDateFormatDemo td = new ThreadLocalSimpleDateFormatDemo();
        // Two threads are created
        Thread t1 = new Thread(td, "Thread-1");
        Thread t2 = new Thread(td, "Thread-2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        System.out.println("Thread run execution started for " + Thread.currentThread().getName());
        System.out.println("Date formatter pattern is  " + dateFormat.get().toPattern());
        System.out.println("Formatted date is " + dateFormat.get().format(new Date()));
    }
}

