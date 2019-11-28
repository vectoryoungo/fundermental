/**
 * @create 2019-07-08 15:17
 * @desc data object
 **/
package com.xlab.service_java_infrastructure.disruptor;

import java.util.Queue;

public class MyData {

    private Queue<MyInnerData> seller;
    private Queue<MyInnerData> buyer;

    //private List<MyInnerData> seller;
    //private List<MyInnerData> buyer;

    /*public List<MyInnerData> getSeller() {
        return seller;
    }

    public void setSeller(List<MyInnerData> seller) {
        this.seller = seller;
    }

    public List<MyInnerData> getBuyer() {
        return buyer;
    }

    public void setBuyer(List<MyInnerData> buyer) {
        this.buyer = buyer;
    }*/

    public Queue<MyInnerData> getSeller() {
        return seller;
    }

    public void setSeller(Queue<MyInnerData> seller) {
        this.seller = seller;
    }

    public Queue<MyInnerData> getBuyer() {
        return buyer;
    }

    public void setBuyer(Queue<MyInnerData> buyer) {
        this.buyer = buyer;
    }
}

