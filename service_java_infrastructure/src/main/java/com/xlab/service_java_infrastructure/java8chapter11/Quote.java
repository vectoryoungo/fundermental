/*
 * module: fundermental
 * file: Quote.java
 * date: 18-6-30 下午4:40
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-30 16:39
 * @desc quote
 **/
package com.xlab.service_java_infrastructure.java8chapter11;

public class Quote {

    private final String shopName;
    private final double price;
    private final Discount.Code discountCode;

    public Quote(String shopName, double price, Discount.Code code) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = code;
    }

    public static Quote parse(String s) {
        String[] split = s.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);
    }
    public String getShopName() { return shopName; }
    public double getPrice() { return price; }
    public Discount.Code getDiscountCode() { return discountCode; }
}

