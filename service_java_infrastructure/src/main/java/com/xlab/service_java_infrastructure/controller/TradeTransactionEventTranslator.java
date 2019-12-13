package com.xlab.service_java_infrastructure.controller;

import com.lmax.disruptor.EventTranslator;

import java.util.PriorityQueue;

public class TradeTransactionEventTranslator implements EventTranslator<TradeTransaction> {


    private OrderDTO orderDTO;
    private PriorityQueue<Trade> buyer = null;
    private PriorityQueue<Trade> seller = null;

    @Override
    public void translateTo(TradeTransaction event, long sequence) {
        this.generateTradeTransaction(event);
    }

    private TradeTransaction generateTradeTransaction(TradeTransaction event){

        //买
        if (orderDTO.getOrderType() == 1) {
            if (buyer == null) {
                buyer = new PriorityQueue<Trade>();
            }
            Trade trade = new Trade();
            trade.setAmount(orderDTO.getAmount());
            trade.setId(String.valueOf(orderDTO.getOrderId()));
            trade.setPrice(orderDTO.getOrderPrice());
            trade.setTime(System.currentTimeMillis());
            buyer.add(trade);
            event.setBuyer(buyer);
            //卖
        }else if (orderDTO.getOrderType() == 2) {
            if (seller == null) {
                seller = new PriorityQueue<Trade>();
            }
            Trade trade = new Trade();
            trade.setAmount(orderDTO.getAmount());
            trade.setId(String.valueOf(orderDTO.getOrderId()));
            trade.setPrice(orderDTO.getOrderPrice());
            trade.setTime(System.currentTimeMillis());
            seller.add(trade);
            event.setSeller(seller);
        }

        return event;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }
}
