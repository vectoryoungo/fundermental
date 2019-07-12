/*
 * module: fundermental
 * file: MathBigDecimalTest.java
 * date: 7/11/19 11:02 AM
 * author: VectorJu
 */

/**
 * @create 2019-07-11 11:02
 * @desc test bigdecimal
 **/
package com.xlab.service_java_infrastructure.basic;

import java.math.BigDecimal;

public class MathBigDecimalTest {

    public static void main(String[] args) {
        BigDecimal balance = new BigDecimal("0.001");
        BigDecimal temp = new BigDecimal("0.0008");

        if (balance.compareTo(temp) < 0) {
            System.out.println(" smaller " + balance.toPlainString() + " be compared no " + temp);
        }else {
            System.out.println(" bigger " + balance.toPlainString() + " be compared no " + temp);
        }
    }
}

