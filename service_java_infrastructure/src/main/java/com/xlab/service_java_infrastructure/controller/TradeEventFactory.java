package com.xlab.service_java_infrastructure.controller;

import com.lmax.disruptor.EventFactory;
import org.springframework.stereotype.Component;

import java.util.PriorityQueue;

public class TradeEventFactory implements EventFactory<TradeTransaction> {

    private  OrderDTO orderDTO;

    public TradeEventFactory(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    @Override
    public TradeTransaction newInstance() {

        TradeTransaction tradeTransaction = new TradeTransaction();
        /*//买
        if (orderDTO.getOrderType() == 1) {
            PriorityQueue<Trade> priorityQueue = null;
             if (priorityQueue == null) {
                 priorityQueue = new PriorityQueue<Trade>();
             }
             Trade trade = new Trade();
             trade.setAmount(orderDTO.getAmount());
             trade.setId(String.valueOf(orderDTO.getOrderId()));
             trade.setPrice(orderDTO.getOrderPrice());
             trade.setTime(System.currentTimeMillis());
            priorityQueue.add(trade);
            tradeTransaction.setBuyer(priorityQueue);
            //卖
        }else if (orderDTO.getOrderType() == 2) {
            PriorityQueue<Trade> priorityQueue = null;
            if (priorityQueue == null) {
                priorityQueue = new PriorityQueue<Trade>();
            }
            Trade trade = new Trade();
            trade.setAmount(orderDTO.getAmount());
            trade.setId(String.valueOf(orderDTO.getOrderId()));
            trade.setPrice(orderDTO.getOrderPrice());
            trade.setTime(System.currentTimeMillis());
            priorityQueue.add(trade);
            tradeTransaction.setSeller(priorityQueue);
        }*/

        return tradeTransaction;
    }
}
