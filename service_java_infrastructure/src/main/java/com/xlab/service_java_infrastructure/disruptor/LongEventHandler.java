package com.xlab.service_java_infrastructure.disruptor;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) throws Exception {

        if (longEvent.getValue() % 2 == 0) {

            for (int i=0;i<1000;i++) {
                //simulate get data from database
            }

            System.out.println(" power 2 and get data from database " + longEvent.getValue());

        }else {
            //simulate get data from cache very fast
            System.out.println(" no power 2 and get data from cache very fast :" + longEvent.getValue());
        }

    }
}
