/*
 * module: fundermental
 * file: SmsTask.java
 * date: 9/29/19 4:25 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-29 16:24
 * @desc test timer task sms task
 **/
package com.xlab.service_java_infrastructure.basic.timer;

import java.util.TimerTask;

public class SmsTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("SmsTask start run.....");
    }
}

