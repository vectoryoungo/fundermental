/*
 * module: fundermental
 * file: PrimeGeneratorSimulator.java
 * date: 6/14/20 9:25 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-14 21:25
 * @desc
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.math.BigInteger;
import java.util.List;

public class PrimeGeneratorSimulator {

    public static void main(String[] args) {

        PrimeGenerator primeGenerator = new PrimeGenerator();
        new Thread(primeGenerator).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<BigInteger> result = primeGenerator.get();
        System.out.println(result.size());
        primeGenerator.cancel();
        System.out.println(primeGenerator.get());
    }
}

