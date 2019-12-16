package com.xlab.service_java_infrastructure.controller;

import com.lmax.disruptor.EventTranslator;

import java.util.Comparator;
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

            Comparator<Trade> buy = new Comparator<Trade>() {
                @Override
                public int compare(Trade o1, Trade o2) {

                    if (o1.getPrice() - o2.getPrice() > 0 ){
                        return -1;
                    }else if (o1.getPrice() - o2.getPrice() < 0) {
                        return 1;
                    }else {
                        return 0;
                    }
                }
            };

            if (buyer == null) {
                buyer = new PriorityQueue<Trade>(buy);
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
            Comparator<Trade> sell = new Comparator<Trade>() {
                @Override
                public int compare(Trade o1, Trade o2) {
                    if (o1.getPrice() - o2.getPrice() > 0) {
                        return 1;
                    }else if (o1.getPrice() - o2.getPrice() < 0) {
                        return -1;
                    }else {
                        return 0;
                    }
                }
            };
            if (seller == null) {
                seller = new PriorityQueue<Trade>(sell);
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
