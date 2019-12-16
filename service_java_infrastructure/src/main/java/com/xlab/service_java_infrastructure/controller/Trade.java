package com.xlab.service_java_infrastructure.controller;

import lombok.Data;

@Data
public class Trade {
    private double price;
    private String id;
    private double amount;
    private long time;
}
