/*
 * module: fundermental
 * file: MailTaskWithoutCancel.java
 * date: 9/29/19 4:43 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-29 16:43
 * @desc test without cancel
 **/
package com.xlab.service_java_infrastructure.basic.timer;

import java.util.Date;
import java.util.TimerTask;

public class MailTaskWithoutCancel extends TimerTask {
    @Override
    public void run() {
        System.out.println("MailTaskWithoutCancel ");
    }
}

