package com.xdlx.service.java.nosql.dto;

public class OrderDTO {

    private Integer orderId;
    private String orderGoods;
    private String orderAddress;
    private String orderDestination;
    private String orderUserId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(String orderGoods) {
        this.orderGoods = orderGoods;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderDestination() {
        return orderDestination;
    }

    public void setOrderDestination(String orderDestination) {
        this.orderDestination = orderDestination;
    }

    public String getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(String orderUserId) {
        this.orderUserId = orderUserId;
    }
}
