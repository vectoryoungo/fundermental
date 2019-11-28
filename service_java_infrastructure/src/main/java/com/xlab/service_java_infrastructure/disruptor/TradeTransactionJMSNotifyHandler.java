/**
 * @create 2019-07-12 16:49
 * @desc TradeTransactionJMSNotifyHandler
 **/
package com.xlab.service_java_infrastructure.disruptor;

import com.lmax.disruptor.EventHandler;

public class TradeTransactionJMSNotifyHandler implements EventHandler<TradeTransaction> {

    @Override
    public void onEvent(TradeTransaction event, long sequence,
                        boolean endOfBatch) throws Exception {
        //do send jms message
        System.out.println(" do JMSNotify ");
    }
}

