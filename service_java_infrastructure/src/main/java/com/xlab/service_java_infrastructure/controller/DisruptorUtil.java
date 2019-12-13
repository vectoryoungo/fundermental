package com.xlab.service_java_infrastructure.controller;

import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.springframework.stereotype.Component;

public class DisruptorUtil {

    private TradeEventFactory tradeEventFactory;
    private Disruptor<TradeTransaction> disruptor;
    private int bufferSize = 1024;

    public DisruptorUtil(TradeEventFactory tradeEventFactory) {
        this.tradeEventFactory = tradeEventFactory;
    }

    public Disruptor<TradeTransaction> getDisruptor() {
        if (disruptor == null) {
            disruptor=new Disruptor<TradeTransaction>(tradeEventFactory, bufferSize, DaemonThreadFactory.INSTANCE, ProducerType.SINGLE, new YieldingWaitStrategy());
        }

        return disruptor;
    }
}
