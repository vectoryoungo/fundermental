/**
 * @create 2019-07-14 09:34
 * @desc MatchingMachineryHandler
 **/
package com.xlab.service_java_infrastructure.disruptor.demo;

import com.lmax.disruptor.EventHandler;

public class Handler2 implements EventHandler<Trade> {

    @Override
    public void onEvent(Trade event, long sequence,  boolean endOfBatch) throws Exception {
        System.out.println("handler2: set price");
        event.setPrice(17.0);
        Thread.sleep(1000);
    }
}

