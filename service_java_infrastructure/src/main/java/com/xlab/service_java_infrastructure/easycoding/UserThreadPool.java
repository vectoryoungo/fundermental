/*
 * module: fundermental
 * file: UserThreadPool.java
 * date: 3/27/19 5:42 PM
 * author: VectorJu
 */

/**
 * @create 2019-03-27 17:42
 * @desc UserThreadPool
 **/
package com.xlab.service_java_infrastructure.easycoding;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import sun.misc.Unsafe;

public class UserThreadPool {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(2);

        UserThreadFactory userThreadFactory = new UserThreadFactory("First Compute House");
        UserThreadFactory userThreadFactory1= new UserThreadFactory("Two Compute House");

        UserRejectHandler handler = new UserRejectHandler();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,2,60, TimeUnit.SECONDS,queue,userThreadFactory,handler);
        ThreadPoolExecutor threadPoolExecutorSecond = new ThreadPoolExecutor(1,2,60,TimeUnit.SECONDS,queue,userThreadFactory1,handler);
        Runnable task = new Task();

        /*for (int i=0;i<200;i++) {
            threadPoolExecutor.execute(task);
            threadPoolExecutorSecond.execute(task);
        }*/

        Long number = 10L;
        System.out.println("result " + (number>>>16));
        System.out.println("result " + (number>>>1));

        System.out.println("INTEGER.SIZE " + Integer.SIZE);
        System.out.println("COUNT_BITS " + COUNT_BITS);
        System.out.println("RUNNING " + RUNNING);
        System.out.println("SHUTDOWN " + SHUTDOWN);
        System.out.println("STOP " + STOP);
        System.out.println("TIDYING " + TIDYING);
        System.out.println("TERMINATED " + TERMINATED);
    }
}

