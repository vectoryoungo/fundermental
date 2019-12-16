package com.xlab.service_java_infrastructure.controller;


import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/order")
public class DisruptorController {

    private TradeTransactionEventTranslator tradeTransactionEventTranslator;
    private TradeTransactionMatchConsumer tradeTransactionMatchConsumer;
    private TradeTransactionBuyConsumer transactionBuyConsumer;
    private TradeTransactionSellConsumer tradeTransactionSellConsumer;
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public boolean addOrder(OrderDTO orderDTO) {
        TradeEventFactory tradeEventFactory = new TradeEventFactory(orderDTO);
        DisruptorUtil disruptorUtil = new DisruptorUtil(tradeEventFactory);
        Disruptor<TradeTransaction> disruptor = disruptorUtil.getDisruptor();

        if (transactionBuyConsumer == null) {
            transactionBuyConsumer = new TradeTransactionBuyConsumer();
        }

        if (tradeTransactionSellConsumer == null) {
            tradeTransactionSellConsumer = new TradeTransactionSellConsumer();
        }
        //使用disruptor创建消费者组C1,C2
        EventHandlerGroup<TradeTransaction> handlerGroup=disruptor.handleEventsWith(transactionBuyConsumer,tradeTransactionSellConsumer);

        if (tradeTransactionMatchConsumer == null) {
            tradeTransactionMatchConsumer = new TradeTransactionMatchConsumer();
        }
        //声明在C1,C2完事之后执行JMS消息发送操作 也就是流程走到C3
        handlerGroup.then(tradeTransactionMatchConsumer);
        disruptor.start();

        if (tradeTransactionEventTranslator == null) {
            tradeTransactionEventTranslator = new TradeTransactionEventTranslator();
        }
        tradeTransactionEventTranslator.setOrderDTO(orderDTO);

        disruptor.publishEvent(tradeTransactionEventTranslator);
        return true;
    }
}
