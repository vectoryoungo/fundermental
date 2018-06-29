/*
 * module: fundermental
 * file: RefactorSimulator.java
 * date: 18-6-27 上午9:03
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-27 09:03
 * @desc refactor
 **/
package com.xlab.service_java_infrastructure.java8chapter8;

import com.xlab.service_java_infrastructure.java8chapter5.Trader;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;

public class RefactorSimulator {

    public static void main(String[] args) {
       /* int a = 10;
        Runnable r1 = () -> {
            int a = 2;// this will lead to compile error
            System.out.println(a);
        };*/

        Runnable r2 = new Runnable(){public void run(){
            int a = 2;
            System.out.println(a);
        }
        };
        //new Thread(r2).start();

        Integer commissionPercent = Integer.MAX_VALUE;
        Double commissionPercentDouble=commissionPercent*0.01;
        BigDecimal result = new BigDecimal("1.235").multiply(new BigDecimal(commissionPercentDouble));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(commissionPercentDouble.toString());
        System.out.println(result.toPlainString());
        System.out.println(new BigDecimal(commissionPercentDouble.toString()).toPlainString());
        Comparator<Trader> comparator = Comparator.comparing(Trader::getName).reversed();


    }
}

