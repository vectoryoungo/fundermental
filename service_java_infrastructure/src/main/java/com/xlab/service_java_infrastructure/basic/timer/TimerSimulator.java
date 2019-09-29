/*
 * module: fundermental
 * file: TimerSimulator.java
 * date: 9/29/19 4:35 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-29 16:35
 * @desc test of timer use case
 **/
package com.xlab.service_java_infrastructure.basic.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * run result :
 * current date time is Sun Sep 29 16:38:40 CST 2019
 * planning run date time is Sun Sep 29 16:38:40 CST 2019
 * MailTask start run ......
 * MailTask remove itself
 * SmsTask start run.....
 * SmsTask start run.....
 * SmsTask start run.....
 * SmsTask start run.....
 * task finish.
 *
 */
public class TimerSimulator {

    public static void main(String[] args) {
        System.out.println("current date time is " + new Date());
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();
        System.out.println("planning run date time is " + runDate);
        MailTask mailTask = new MailTask();
        SmsTask smsTask = new SmsTask();
        Timer timer = new Timer();
        timer.schedule(mailTask,runDate,3000);
        timer.schedule(smsTask,runDate,3000);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println(" task finish.");
    }
}

