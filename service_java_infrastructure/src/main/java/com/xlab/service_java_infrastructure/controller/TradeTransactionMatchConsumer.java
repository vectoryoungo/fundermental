package com.xlab.service_java_infrastructure.controller;

import com.lmax.disruptor.EventHandler;

import java.util.Iterator;
import java.util.PriorityQueue;

//撮合
public class TradeTransactionMatchConsumer implements EventHandler<TradeTransaction> {


    @Override
    public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {

        PriorityQueue<Trade> seller = event.getSeller();
        PriorityQueue<Trade> buyer = event.getBuyer();

        if (seller != null) {
            Iterator sellIterator = seller.iterator();
            if (sellIterator != null) {
                while (sellIterator.hasNext()) {
                    Trade trade = (Trade) sellIterator.next();
//            System.out.println(" trade sell id " + trade.getId());
//            System.out.println(" trade sell time " + trade.getTime());
                    System.out.println(" trade sell price " + trade.getPrice());
//            System.out.println(" trade sell amount " + trade.getAmount());
                }
            }
        }

        if (buyer != null) {
            Iterator buyIterator = buyer.iterator();

            if (buyIterator != null) {
                while (buyIterator.hasNext()) {
                    Trade trade = (Trade) buyIterator.next();
                    System.out.println(" trade buy price " + trade.getPrice());
                }
            }
        }
    }
}
