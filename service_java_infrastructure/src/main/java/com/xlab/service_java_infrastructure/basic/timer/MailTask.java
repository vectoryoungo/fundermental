/*
 * module: fundermental
 * file: MailTask.java
 * date: 9/29/19 4:23 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-29 16:23
 * @desc test timer task mail task class
 **/
package com.xlab.service_java_infrastructure.basic.timer;

import java.util.TimerTask;

public class MailTask extends TimerTask{


    @Override
    public void run() {
        System.out.println("MailTask start run ......");
        this.cancel();
        System.out.println("MailTask remove itself ");
    }
}

