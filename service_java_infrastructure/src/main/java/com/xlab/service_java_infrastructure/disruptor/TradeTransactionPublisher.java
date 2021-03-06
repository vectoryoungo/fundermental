/**
 * @create 2019-07-12 16:49
 * @desc TradeTransactionPublisher
 **/
package com.xlab.service_java_infrastructure.disruptor;

import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.CountDownLatch;

public class TradeTransactionPublisher implements Runnable{
    Disruptor<TradeTransaction> disruptor;
    private CountDownLatch latch;
    private static int LOOP=1000000;//模拟一千万次交易的发生

    public TradeTransactionPublisher(CountDownLatch latch,Disruptor<TradeTransaction> disruptor) {
        this.disruptor=disruptor;
        this.latch=latch;
    }

    public TradeTransactionPublisher() {}

    @Override
    public void run() {
        TradeTransactionEventTranslator tradeTransloator=new TradeTransactionEventTranslator();
        for(int i=0;i<LOOP;i++){
            disruptor.publishEvent(tradeTransloator);
        }
        latch.countDown();
    }
}

