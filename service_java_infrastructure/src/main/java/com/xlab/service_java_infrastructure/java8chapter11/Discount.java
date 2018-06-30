/*
 * module: fundermental
 * file: Discount.java
 * date: 18-6-30 下午4:32
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-30 16:32
 * @desc dicount percentage
 **/
package com.xlab.service_java_infrastructure.java8chapter11;

import static com.xlab.service_java_infrastructure.java8chapter11.Shop.delay;

public class Discount {

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
        private final int percentage;
        Code(int percentage) {
            this.percentage = percentage;
        }
    }
    //将折扣代码应
    //用于商品最初
    //的原始价格
    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " +
                Discount.apply(quote.getPrice(),
                        quote.getDiscountCode());
    }

    //模拟Discount
    //服务响应的延迟
    private static double apply(double price, Code code) {
        delay();
        return price * (100 - code.percentage) / 100;
    }
}

