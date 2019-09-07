/*
 * module: fundermental
 * file: BasicFeatureExplore.java
 * date: 4/29/19 10:35 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-29 10:35
 * @desc basic feature of java
 **/
package com.xlab.service_java_infrastructure.basic;

import com.xlab.service_java_infrastructure.basic.map.MyCallable;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

import static java.util.concurrent.Executors.*;

public class BasicFeatureExplore {

    public static void main(String[] args) {

        ConcurrentHashMap<Object,Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("","");
        HashMap hashMap  = new HashMap();
        HashSet hashSet = new HashSet();
        TreeSet treeSet = new TreeSet();
        treeSet.add(new String("treeset test"));
        Comparable comparable;
        Comparator comparator;
        ThreadLocal threadLocal = null;
        threadLocal.get();
        threadLocal.set(null);
        threadLocal.remove();
        ReentrantLock reentrantLock;
        StampedLock stampedLock;
        ReentrantReadWriteLock reentrantReadWriteLock;
        ArrayList arrayList = new ArrayList();
        arrayList.add("she");
        Callable callable;
        Runnable runnable;
        ExecutorService executorService;
        Thread thread = new Thread();
        thread.stop();
        Executors.newFixedThreadPool(4);
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(4);
        Executors.newCachedThreadPool();
        Executors.newWorkStealingPool();
        newSingleThreadExecutor();
        newFixedThreadPool(10);
        newCachedThreadPool().submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("submit");
            }
        });
        newScheduledThreadPool(10);



        int number = 1 << 4;
        int numberTwo = 1 << 3;
        int numberThree = 1 << 2;
        int numberFour = 1 << 1;
        int max = 1 <<30;
        int numberRight = 1 >>> 16;
        int numberRightTwo = 1 >>> 8;
        int numberRightThree = 12 >>> 16;
        System.out.println("number 1<<4 " + number);
        System.out.println("numberTwo 1<<3 " + numberTwo);
        System.out.println("numherThree 1<<2 " + numberThree);
        System.out.println("numberFour 1<<1 " + numberFour);
        System.out.println(" max is " + max);

        hashMap.put("key","fuck");
        hashMap.get("key");
        System.out.println(hashMap.get("key"));
        System.out.println("numberRight " + numberRight);
        System.out.println("numberRightTwo " + numberRightTwo);
        System.out.println("numberRightThree " + numberRightThree);
        System.out.println("+++++++++++++++++++++++++");
        process(10);
        int numbersN = 4;
        int numnberNN = 4;
        System.out.println(numbersN | numnberNN);

        BasicFeatureExplore basicFeatureExplore = new BasicFeatureExplore();
        basicFeatureExplore.executorTest(4);

    }

    private static void process(int cap) {
        int n = cap - 1;
        System.out.println("before first is " + n);
        n = n | n >>> 1;
        System.out.println(" n = n | n >>> 1 " +n);
        /*n |= n >>> 1;
        System.out.println(" first >>>1 is " + n);
        n |= n >>> 2;
        System.out.println(" second >>>2 is " +n);
        n |= n >>> 4;
        System.out.println(" third >>>4 is " + n);
        n |= n >>> 8;
        System.out.println(" fourth >>>8 is " + n);
        n |= n >>> 16;
        System.out.println(" fifth >>> 16 is " + n);*/
    }

    public void executorTest(int taskSize) {
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyCallable(i + " MyCallable Instance ");
            // 执行任务并获取Future 对象
            Future f = pool.submit(c);
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();
        // 获取所有并发任务的运行结果
        for (Future f : list) {
            try {
                if (f.isDone()) {
                    // 从Future 对象上获取任务的返回值，并输出到控制台
                    System.out.println("res：" + f.get().toString());
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

