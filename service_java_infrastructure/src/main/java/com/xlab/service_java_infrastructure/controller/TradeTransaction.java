package com.xlab.service_java_infrastructure.controller;

import lombok.Data;

import java.util.PriorityQueue;

@Data
public class TradeTransaction {
    private PriorityQueue<Trade> buyer;
    private PriorityQueue<Trade> seller;
}

