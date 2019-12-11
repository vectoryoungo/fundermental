/**
 * @create 2019-07-12 16:51
 * @desc Demo3
 **/
package com.xlab.service_java_infrastructure.disruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

public class Demo4 {

    public static void main(String[] args) throws InterruptedException {
        long beginTime=System.currentTimeMillis();
        String beginStr = String.valueOf(beginTime);
        BigDecimal start = new BigDecimal(beginStr);

        int bufferSize=1024;
        //这个构造函数参数，相信你在了解上面2个demo之后就看下就明白了，不解释了~
        Disruptor<TradeTransaction> disruptor=new Disruptor<TradeTransaction>(new EventFactory<TradeTransaction>() {
            @Override
            public TradeTransaction newInstance() {
                return new TradeTransaction();
            }
        }, bufferSize, DaemonThreadFactory.INSTANCE, ProducerType.SINGLE, new YieldingWaitStrategy());
        //使用disruptor创建消费者组C1,C2
        EventHandlerGroup<TradeTransaction> handlerGroup=disruptor.handleEventsWith(new TradeTransactionVasConsumer(),new TradeTransactionInDBHandler());

        TradeTransactionJMSNotifyHandler jmsConsumer=new TradeTransactionJMSNotifyHandler();
        //声明在C1,C2完事之后执行JMS消息发送操作 也就是流程走到C3
        handlerGroup.then(jmsConsumer);

        disruptor.start();//启动
        CountDownLatch latch=new CountDownLatch(1);
        TradeTransactionEventTranslator tradeTransloator=new TradeTransactionEventTranslator();
        for(int i=0;i<1000000;i++){
            disruptor.publishEvent(tradeTransloator);
        }
        latch.countDown();
        disruptor.shutdown();
        long end = System.currentTimeMillis();
        String endStr = String.valueOf(end);
        BigDecimal endBig = new BigDecimal(endStr);
        BigDecimal middle = endBig.subtract(start);
        BigDecimal finalTime = middle.divide(new BigDecimal("1000"));
        System.out.println("总耗时:"+ finalTime.toPlainString() + " s");
    }
}


