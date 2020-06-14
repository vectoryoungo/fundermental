/**
 * @create 2020-06-14 22:48
 * @desc 通过使用中断进行取消
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeProducer extends Thread{

    private final BlockingQueue<BigInteger> queue;
    PrimeProducer(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(p = p.nextProbablePrime());
            }
        }catch (InterruptedException e) {
            //允许线程退出
        }
    }

    public void cancel() {
        interrupt();
    }
}

