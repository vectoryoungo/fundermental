package com.xlab.service_java_infrastructure.disruptor;

import com.lmax.disruptor.EventFactory;

public class LongEventFactory implements EventFactory<LongEvent> {

    public LongEvent newInstance()
    {
        return new LongEvent();
    }

}
