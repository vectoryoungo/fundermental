package com.xlab.service_java_infrastructure.controller;

import com.lmax.disruptor.EventHandler;

import java.util.PriorityQueue;

//买单
public class TradeTransactionBuyConsumer implements EventHandler<TradeTransaction> {

    private PriorityQueue<Trade> buyer;

    @Override
    public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {
        buyer = event.getBuyer();
        if (buyer != null){
            int buyNum = buyer.size();
            if (buyNum > 0) {
                System.out.println("买单 " + buyNum + " 个");
            }
        }
    }
}
