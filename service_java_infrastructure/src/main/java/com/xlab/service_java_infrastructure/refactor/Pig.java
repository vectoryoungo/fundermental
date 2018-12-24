/*
 * module: fundermental
 * file: Pig.java
 * date: 10/22/18 7:10 PM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-10-22 19:10
 * @desc pig refactor of animal
 **/
package com.xlab.service_java_infrastructure.refactor;

import java.math.BigDecimal;

public class Pig implements Animal{

    @Override
    public void show() {
        System.out.println("this is pig class ");
//        BigDecimal bigDecimal = new BigDecimal(Long.valueOf("11.00000000"));
        BigDecimal bigDecimal1 = new BigDecimal("11.00000000");
//        System.out.println(" bigDecimal " + bigDecimal.toPlainString());
//        System.out.println(" bigDecimal " + bigDecimal.toString());
        System.out.println(" bigdecimal1 " + bigDecimal1.toString());
        System.out.println(" bigdecimal1 " + bigDecimal1.toPlainString());
    }


    public static void main(String[] args) {
        String str = "first";
        boolean booleanSecond = false;
        boolean booleanTird = false;

        for(int i=0;i<3;i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    if ("first".equals(str) && !booleanSecond && !booleanTird) {
                        System.out.println(" this is test : " + !booleanSecond + !booleanTird);
                    }
                }
            }).start();

        }
    }
}

