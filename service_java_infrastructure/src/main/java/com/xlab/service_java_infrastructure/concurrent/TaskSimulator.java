/**
 * @create 2020-06-14 23:21
 * @desc 不可取消的任务在退出前保存中断
 **/
package com.xlab.service_java_infrastructure.concurrent;

import com.xlab.service_java_infrastructure.java8chapter1.Comparator;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class TaskSimulator{


    Object object;

    public Task getNextTask(BlockingQueue<Task> queue) {
        boolean interrupted = false;

        try {
                while (true){
                    try {
                        return queue.take();
                    }catch (InterruptedException e) {
                        interrupted = true;
                        //失败并重试
                    }
                }

        }finally {
            if (interrupted){
                Thread.currentThread().interrupt();
            }
        }
    }
}

