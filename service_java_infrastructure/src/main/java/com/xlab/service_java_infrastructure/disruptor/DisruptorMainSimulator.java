/**
 * @create 2019-07-08 15:21
 * @desc simulator
 * 1000000
 * this test use ArrayList takes 1506s
 * use ArrayBlockingQueue takes 1356s
 * use LinkedBlockingQueue takes 1279s
 **/
package com.xlab.service_java_infrastructure.disruptor;

import com.lmax.disruptor.IgnoreExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.math.BigDecimal;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class DisruptorMainSimulator {

    public static void main(String[] args) {
         ExecutorService executorService = Executors.newFixedThreadPool(4);
         int bufferSize = 1024 * 1024;
        Disruptor<MyTradeEvent> disruptor = new Disruptor<MyTradeEvent>(new MyTradeEventFactory(),
                bufferSize, executorService, ProducerType.SINGLE, new YieldingWaitStrategy());
        disruptor.handleExceptionsWith(new IgnoreExceptionHandler());
        disruptor.handleEventsWith(new MyTradeEventHandler());
        RingBuffer<MyTradeEvent> ringBuffer = disruptor.start();
        MyTradeProducer myTradeProducer = new MyTradeProducer(ringBuffer);

        long start = System.nanoTime();

        Queue<MyInnerData> seller = new LinkedBlockingQueue<MyInnerData>(1024*512);
        Queue<MyInnerData> buyer = new LinkedBlockingQueue<MyInnerData>(1024*512);
        //Queue<MyInnerData> seller = new ArrayBlockingQueue<MyInnerData>(1024*512);
        //Queue<MyInnerData> buyer = new ArrayBlockingQueue<MyInnerData>(1024*512);
        //List<MyInnerData> seller = new CopyOnWriteArrayList<MyInnerData>();
        //List<MyInnerData> buyer = new CopyOnWriteArrayList<MyInnerData>();

        for (int i=0;i<1000000;i++) {
            MyData myData = new MyData();
            MyInnerData myInnerData = new MyInnerData();
            myInnerData.setAmount(new BigDecimal(i));

            myInnerData.setTxType(1);
            myInnerData.setOrderNo(UUID.randomUUID().toString());
            int random = (int)(Math.random()*100+1);
            myInnerData.setPrice(new BigDecimal(random));
            myInnerData.setRelationId(i);

            myInnerData.setUserId(Long.valueOf(i));

            if (i%2==0) {
                myInnerData.setBusinessType(2);
                seller.add(myInnerData);
            }else {
                myInnerData.setBusinessType(1);
                buyer.add(myInnerData);

            }

            myData.setBuyer(buyer);
            myData.setSeller(seller);
            myTradeProducer.onData(myData);

            try {
                Thread.sleep(1);// wait for task execute....
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" loop inner i is " + i);
        }
        long estimatedTime = System.nanoTime() - start;
        System.out.println(" it takes " + TimeUnit.NANOSECONDS.toSeconds(estimatedTime));
        disruptor.shutdown();
        ExecutorsUtils.shutdownAndAwaitTermination(executorService, 60, TimeUnit.SECONDS);
    }
}

