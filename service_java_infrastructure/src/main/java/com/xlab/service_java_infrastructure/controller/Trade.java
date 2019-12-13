package com.xlab.service_java_infrastructure.controller;

import lombok.Data;

@Data
public class Trade implements Comparable<Trade>{
    private double price;
    private String id;
    private double amount;
    private long time;

    @Override
    public int compareTo(Trade o) {

        if ( o.getPrice() - this.price > 0) {

            /*if (o.getTime() - this.time > 0){
                return 1;
            }else if (o.getTime() - this.time < 0) {
                return -1;
            }else if (o.getTime() - this.time == 0){
                return 0;
            }else {
                return 1;
            }*/
            return 1;
        }

        if ( o.getPrice() - this.price == 0) {
            return 0;
        }

        if ( o.getPrice() - this.price < 0) {
            return -1;
        }

        return -3;
    }
}
