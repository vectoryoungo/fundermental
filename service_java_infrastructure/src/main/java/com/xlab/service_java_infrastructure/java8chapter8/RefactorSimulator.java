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
    }
}

