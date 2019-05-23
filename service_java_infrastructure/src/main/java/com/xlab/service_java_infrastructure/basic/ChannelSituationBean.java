/*
 * module: fundermental
 * file: ChannelSituationBean.java
 * date: 5/19/19 3:53 PM
 * author: VectorJu
 */

/**
 * @create 2019-05-19 15:53
 * @desc
 **/
package com.xlab.service_java_infrastructure.basic;

import java.io.Serializable;
import java.util.Date;

public class ChannelSituationBean implements Serializable {

    private static final long serialVersionUID = 5754354214462805574L;

    private Integer id;
    private Date date;
    private int registCount;
    private Float fee;
    private float myFee;
    private Double investMoney;
    private double myInvestMoney;
    private String registChannel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRegistCount() {
        return registCount;
    }

    public void setRegistCount(int registCount) {
        this.registCount = registCount;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public float getMyFee() {
        return myFee;
    }

    public void setMyFee(float myFee) {
        this.myFee = myFee;
    }

    public Double getInvestMoney() {
        return investMoney;
    }

    public void setInvestMoney(Double investMoney) {
        this.investMoney = investMoney;
    }

    public double getMyInvestMoney() {
        return myInvestMoney;
    }

    public void setMyInvestMoney(double myInvestMoney) {
        this.myInvestMoney = myInvestMoney;
    }

    public String getRegistChannel() {
        return registChannel;
    }

    public void setRegistChannel(String registChannel) {
        this.registChannel = registChannel;
    }
}

