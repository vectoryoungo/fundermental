/*
 * module: fundermental
 * file: TimerTaskSimulator.java
 * date: 9/29/19 4:22 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-29 16:22
 * @desc test TimerTask class use case
 **/
package com.xlab.service_java_infrastructure.basic.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * run result :
 * current date time is Sun Sep 29 16:29:09 CST 2019
 * planning time is  Sun Sep 29 16:29:09 CST 2019
 * MailTask start run ......
 * MailTask remove itself
 * SmsTask start run.....
 * SmsTask start run.....
 * SmsTask start run.....
 * SmsTask start run.....
 * SmsTask start run.....
 * SmsTask start run.....
 * SmsTask start run.....
 * SmsTask start run.....
 * SmsTask start run.....
 * SmsTask start run.....
 * SmsTask start run.....
 * @description: TimerTask or Timer's cancel() method is do the same thing, clear task of task queue.
 *  but TimerTask is focus on clear the task of itself from task queue. Timer's cancel() is clear all the task of task queue
 */
public class TimerTaskSimulator {

    public static void main(String[] args) {
        System.out.println("current date time is " + new Date());
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();
        System.out.println("planning time is  " + runDate);
        MailTask mailTask = new MailTask();
        SmsTask smsTask = new SmsTask();
        Timer timer = new Timer();
        timer.schedule(mailTask,runDate,3000);
        timer.schedule(smsTask,runDate,3000);
    }
}

