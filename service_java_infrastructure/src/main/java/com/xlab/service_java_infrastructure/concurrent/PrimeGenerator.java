/*
 * module: fundermental
 * file: PrimeGenerator.java
 * date: 6/14/20 9:19 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-14 21:19
 * @desc test cancel task
 **/
package com.xlab.service_java_infrastructure.concurrent;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator implements Runnable{

    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return  new ArrayList<>(primes);
    }
}

