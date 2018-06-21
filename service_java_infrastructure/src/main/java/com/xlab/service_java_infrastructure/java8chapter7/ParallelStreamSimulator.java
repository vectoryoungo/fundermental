/*
 * module: ${PROJECT_NAME}
 * file: ${FILE_NAME}
 * date: ${DATE}
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-21 08:21
 * @desc simulation of parallet stream use
 **/
package com.xlab.service_java_infrastructure.java8chapter7;

import java.util.stream.Stream;

public class ParallelStreamSimulator {

    //接受数字n作为参数，并返回从1到给定参数的所有数字的和，花费时间第一次128毫秒 corei7 四核 16G 256 solid disk
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    //传统的java循环方式 第一次运行花费时间1毫秒  corei7 四核 16G 256 solid disk
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    //并行流计算corei7 四核 16G 256 solid disk 第一次运行95毫秒花费
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    //可能以为把这两个方法结合起来，就可以更细化地控制在遍历流时哪些操作要并行执行，哪些要
    //顺序执行。
    /**
     *
     * stream.parallel()
     * .filter(...)
     * .sequential()
     * .map(...)
     * .parallel()
     * .reduce();
     * 但最后一次parallel或sequential调用会影响整个流水线。在本例中，流水线会并行执
     * 行，因为最后调用的是它。
     * **/

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = iterativeSum(1000);
        System.out.println("result " + result);
        System.out.println(" it takes " + (System.currentTimeMillis()-start) + " million seconds");
    }


}

