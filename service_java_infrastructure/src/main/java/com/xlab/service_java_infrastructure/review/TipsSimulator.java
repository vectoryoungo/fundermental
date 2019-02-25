/*
 * module: fundermental
 * file: TipsSimulator.java
 * date: 2/25/19 10:43 AM
 * author: VectorJu
 */

/**
 * @create 2019-02-25 10:43
 * @desc tips
 **/
package com.xlab.service_java_infrastructure.review;

public class TipsSimulator {

    public static void main(String[] args) {

        int [] numbersArray = new int []{234,345,444,3344,1,50,16,4567,8654};

        for (int item:numbersArray) {
            new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(item);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(item);
                    }
                }
            ).start();
        }
    }
}

