/**
 * @create 2019-07-12 16:51
 * @desc TradeTransactionVasConsumer
 **/
package com.xlab.service_java_infrastructure.disruptor;

import com.lmax.disruptor.EventHandler;

public class TradeTransactionVasConsumer implements EventHandler<TradeTransaction> {

    @Override
    public void onEvent(TradeTransaction event, long sequence,
                        boolean endOfBatch) throws Exception {
        //do something....
        System.out.println("TradeTransactionVasConsumer TradeTransaction id " + event.getId());
        System.out.println("TradeTransactionVasConsumer TradeTransaction price " + event.getPrice());
    }
}

