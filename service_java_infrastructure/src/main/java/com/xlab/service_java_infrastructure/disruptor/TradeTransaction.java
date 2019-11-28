/**
 * @create 2019-07-12 16:43
 * @desc TradeTransaction
 **/
package com.xlab.service_java_infrastructure.disruptor;

import lombok.Data;

@Data
public class TradeTransaction {
    private String id;//交易ID
    private double price;//交易金额
}

