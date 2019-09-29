/*
 * module: fundermental
 * file: MsgTask.java
 * date: 9/29/19 4:51 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-29 16:50
 * @desc test Timer with occasionally non stop
 **/
package com.xlab.service_java_infrastructure.basic.timer;

import java.util.TimerTask;

public class MsgTask extends TimerTask {

    private int i;
    public MsgTask(int i) {
        super();
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println(i+" no canceled ");
    }
}

