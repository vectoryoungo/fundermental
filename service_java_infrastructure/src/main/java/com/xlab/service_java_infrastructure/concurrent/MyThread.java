/*
 * module: fundermental
 * file: MyThread.java
 * date: 6/8/20 6:47 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-08 18:47
 * @desc
 **/
package com.xlab.service_java_infrastructure.concurrent;

public class MyThread implements Runnable{
    private int flag;
    private int queueSize;

    public MyThread(int flag,int queueSize) {
        this.flag = flag;
        this.queueSize = queueSize;
    }

    @Override
    public void run() {
        System.out.println("线程编号：" + getFlag() + "   队列size：" + queueSize);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public int getFlag() {
        return flag;
    }
}

