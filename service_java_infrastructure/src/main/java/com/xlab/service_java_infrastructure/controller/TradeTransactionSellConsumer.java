package com.xlab.service_java_infrastructure.controller;

import com.lmax.disruptor.EventHandler;

import java.util.PriorityQueue;

//卖单
public class TradeTransactionSellConsumer implements EventHandler<TradeTransaction> {


    private PriorityQueue<Trade> seller;

    @Override
    public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {
       seller =  event.getSeller();

       if (seller != null) {
           if (seller.size() > 0){
               System.out.println("卖单 " + seller.size() + " 个");
           }
       }
    }
}
