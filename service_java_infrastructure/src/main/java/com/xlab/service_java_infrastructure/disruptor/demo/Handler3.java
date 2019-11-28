/**
 * @create 2019-07-14 09:34
 * @desc Handler3
 **/
package com.xlab.service_java_infrastructure.disruptor.demo;

import com.lmax.disruptor.EventHandler;

public class Handler3 implements EventHandler<Trade> {
    @Override
    public void onEvent(Trade event, long sequence,  boolean endOfBatch) throws Exception {
        System.out.println("handler3: name: " + event.getName() + " , price: " + event.getPrice() + ";  instance: " + event.toString());
    }
}

