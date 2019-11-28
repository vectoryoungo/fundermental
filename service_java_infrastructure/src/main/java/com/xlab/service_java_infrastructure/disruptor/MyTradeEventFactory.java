/**
 * @create 2019-07-08 15:14
 * @desc factory
 **/
package com.xlab.service_java_infrastructure.disruptor;

import com.lmax.disruptor.EventFactory;

public class MyTradeEventFactory implements EventFactory<MyTradeEvent> {

    public MyTradeEvent newInstance() {
        return new MyTradeEvent();
    }
}

