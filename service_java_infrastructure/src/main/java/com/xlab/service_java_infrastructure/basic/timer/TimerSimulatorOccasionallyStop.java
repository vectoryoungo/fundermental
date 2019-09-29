/*
 * module: fundermental
 * file: TimerSimulatorOccasionallyStop.java
 * date: 9/29/19 4:49 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-29 16:49
 * @desc test timer use case with occasinoally stop
 **/
package com.xlab.service_java_infrastructure.basic.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * 没有清空队列中的全部任务，原因是Timer类中的cancel()方法有时并没有抢到queue锁，则让TimerTask类中的任务正常执行
 */
public class TimerSimulatorOccasionallyStop {

    public static void main(String[] args) {
        int i =0;
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();
        System.out.println("still no canceled ");
        while (true) {
            i++;
            Timer timer = new Timer();
            MsgTask msgTask = new MsgTask(i);
            timer.schedule(msgTask,runDate);
            timer.cancel();
        }
    }
}

