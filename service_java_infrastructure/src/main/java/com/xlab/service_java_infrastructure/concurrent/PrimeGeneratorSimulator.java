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

public class PrimeGeneratorSimulator {

    public static void main(String[] args) {
        for (int i =0;i<10;i++) {
            PrimeGenerator primeGenerator = new PrimeGenerator();
            new Thread(primeGenerator).start();
            primeGenerator.cancel();
        }
    }
}

