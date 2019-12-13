package com.xlab.service_java_infrastructure.controller;

import com.lmax.disruptor.EventHandler;

//撮合
public class TradeTransactionMatchConsumer implements EventHandler<TradeTransaction> {


    @Override
    public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {

    }
}
