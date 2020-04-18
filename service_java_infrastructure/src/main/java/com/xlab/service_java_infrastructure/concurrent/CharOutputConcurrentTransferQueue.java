/*
 * module: fundermental
 * file: CharOutputConcurrentTransferQueue.java
 * date: 4/18/20 11:50 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-18 23:50
 * @desc 利用TransferQueue实现交替输出,TransferQueue的特性是容量为0的队列，可以理解为非诚勿扰里范伟和葛优手里拿的那个筒
 * 必须是A拿着一个物品放在这桶里，等到B取走才行，B不取走，A一直拿着在队列中。A和B必须成对出现。
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class CharOutputConcurrentTransferQueue {

    public static void main(String[] args) {
        char[] sequenceFirst = "1234567".toCharArray();
        char[] sequenceSecond= "ABCDEFG".toCharArray();

        TransferQueue<Character> queue = new LinkedTransferQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c:sequenceFirst) {
                    try {
                        //将字符C也就是1放入队列等待另一个线程去获取。阻塞操作。
                        queue.transfer(c);
                        System.out.println(queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"threadFirst").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c:sequenceSecond){
                    try {
                        //从队列里获取线程1放的字符
                        System.out.println(queue.take());
                        //将字符c放到队列等线程1去获取
                        queue.transfer(c);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        },"threadSecond").start();
    }
}

