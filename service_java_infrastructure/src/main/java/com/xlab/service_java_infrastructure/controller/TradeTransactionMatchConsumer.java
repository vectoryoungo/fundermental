package com.xlab.service_java_infrastructure.controller;

import com.lmax.disruptor.EventHandler;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

//撮合
public class TradeTransactionMatchConsumer implements EventHandler<TradeTransaction> {

    private PriorityQueue<Trade> sellerAll = null;
    private PriorityQueue<Trade> buyerAll = null;

    @Override
    public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {

        if (sellerAll == null) {
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
            sellerAll = new PriorityQueue<Trade>(sell);
        }

        if (buyerAll == null) {
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
            buyerAll = new PriorityQueue<Trade>(buy);
        }


        int  buySize = 0;
        int  sellSize = 0;
        PriorityQueue<Trade> seller = event.getSeller();
        PriorityQueue<Trade> buyer = event.getBuyer();

        if (seller != null) {
            sellerAll.addAll(seller);
            sellSize = sellerAll.size();
            Iterator<Trade> sellIterator = sellerAll.iterator();
            if (sellIterator != null) {
                while (sellIterator.hasNext()) {
                    Trade trade = sellIterator.next();
//            System.out.println(" trade sell id " + trade.getId());
//            System.out.println(" trade sell time " + trade.getTime());
                    System.out.println(" trade sell price " + trade.getPrice());
//            System.out.println(" trade sell amount " + trade.getAmount());
                }
            }
        }

        if (buyer != null) {
            buyerAll.addAll(buyer);
            buySize = buyerAll.size();
            Iterator<Trade> buyIterator = buyerAll.iterator();

            if (buyIterator != null) {
                while (buyIterator.hasNext()) {
                    Trade trade =  buyIterator.next();
                    System.out.println(" trade buy price " + trade.getPrice());
                }
            }
        }

        if (buySize > sellSize) {
            if (buyerAll != null && sellerAll != null) {
                System.out.println(" buySize > sellSize ");
                Iterator<Trade> sellIterator = sellerAll.iterator();
                while (sellIterator.hasNext()) {
                    Trade sellTrade = sellIterator.next();
                    Iterator<Trade> buyIterator = buyerAll.iterator();
                    while (buyIterator.hasNext()) {
                        Trade buyTrade = buyIterator.next();
                        if (sellTrade.getPrice() < buyTrade.getPrice()){
                            if(buyTrade.getAmount() > sellTrade.getAmount()) {
                                System.out.println(" 全部吃掉，还剩 " + (buyTrade.getAmount() - sellTrade.getAmount()) + " 没有买到");
                            }else if (buyTrade.getAmount() < sellTrade.getAmount()) {
                                System.out.println(" 没有全部吃掉,买了 " + buyTrade.getAmount() + " 卖的还剩 " + (sellTrade.getAmount() - buyTrade.getAmount())+ " 没有卖掉");
                            } else if (buyTrade.getAmount() == sellTrade.getAmount()){
                                System.out.println(" 全部成交，完美匹配");
                                buyIterator.remove();
                                sellIterator.remove();
                            }
                        }
                    }
                }
            }
        }else if (buySize < sellSize){
            if (buyerAll != null && sellerAll != null) {
                Iterator<Trade> buyIterator = buyerAll.iterator();
                System.out.println(" buySize < sellSize ");
                while (buyIterator.hasNext()) {
                    Trade buyTrade = buyIterator.next();
                    Iterator<Trade> sellIterator = sellerAll.iterator();
                    while (sellIterator.hasNext()) {
                        Trade sellTrade = sellIterator.next();
                        if (sellTrade.getPrice() < buyTrade.getPrice()){
                            if (buyTrade.getAmount() > sellTrade.getAmount()) {
                                System.out.println(" 全部吃掉，还剩 " + (buyTrade.getAmount() - sellTrade.getAmount()) + " 没有买到");
                            }else if (buyTrade.getAmount() < sellTrade.getAmount()) {
                                System.out.println(" 没有全部吃掉,买了 " + buyTrade.getAmount() + " 卖的还剩 " + (sellTrade.getAmount() - buyTrade.getAmount())+ " 没有卖掉");
                            }else if (buyTrade.getAmount() == sellTrade.getAmount()){
                                System.out.println(" 全部成交，完美匹配");
                                buyIterator.remove();
                                sellIterator.remove();
                            }
                        }
                    }
                }
            }
        } else if (buySize == sellSize) {
            if (buyerAll != null && sellerAll != null) {
                System.out.println(" buySize = sellSize ");
                Iterator<Trade> buyIterator = buyerAll.iterator();
                Iterator<Trade> sellIterator = sellerAll.iterator();
                while (buyIterator.hasNext()) {
                    Trade buyTrade = buyIterator.next();
                    Trade sellTrade = sellIterator.next();
                    if (sellTrade.getPrice() < buyTrade.getPrice()) {
                        if (buyTrade.getAmount() > sellTrade.getAmount()) {
                            System.out.println(" 全部吃掉，还剩 " + (buyTrade.getAmount() - sellTrade.getAmount()) + " 没有买到");
                        }else if (buyTrade.getAmount() < sellTrade.getAmount()) {
                            System.out.println(" 没有全部吃掉,买了 " + buyTrade.getAmount() + " 卖的还剩 " + (sellTrade.getAmount() - buyTrade.getAmount())+ " 没有卖掉");
                        }else if (buyTrade.getAmount() == sellTrade.getAmount()){
                            System.out.println(" 全部成交，完美匹配");
                            buyIterator.remove();
                            sellIterator.remove();
                        }
                    }
                }
            }
        }
    }
}
