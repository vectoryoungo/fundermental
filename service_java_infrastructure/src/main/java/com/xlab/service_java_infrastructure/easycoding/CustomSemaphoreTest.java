/*
 * module: fundermental
 * file: CustomSemaphoreTest.java
 * date: 3/26/19 4:02 PM
 * author: VectorJu
 */

/**
 * @create 2019-03-26 16:02
 * @desc CustomSemaphoreTest
 **/
package com.xlab.service_java_infrastructure.easycoding;

import java.util.concurrent.Semaphore;

public class CustomSemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i=1;i<=5;i++){
            new SecurityCheckThread(i,semaphore).start();
        }
    }

    private static class SecurityCheckThread extends Thread {
        private int seq;
        private Semaphore semaphore;

        public SecurityCheckThread (int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("No. " + seq + " in checking ");

                //
                if (seq % 2 == 0) {
                    Thread.sleep(1000);
                    System.out.println("NO. " + seq + "fuck this is dog keeper alibaba ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("No. " + seq + " scene");
            }
        }
    }
}

