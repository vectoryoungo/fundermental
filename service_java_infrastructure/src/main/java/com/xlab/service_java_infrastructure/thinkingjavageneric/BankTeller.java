/*
 * module: fundermental
 * file: BankTeller.java
 * date: 4/8/19 5:54 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-08 17:54
 * @desc test of customer and teller
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class BankTeller {

    public static void serve(Teller teller,Customer customer) {
        System.out.println(teller + " serves " + customer);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> line = new LinkedList<Customer>();
        
    }
}

