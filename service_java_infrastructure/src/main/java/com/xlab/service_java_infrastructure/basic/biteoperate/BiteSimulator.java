/*
 * module: fundermental
 * file: BiteSimulator.java
 * date: 7/25/19 10:21 AM
 * author: VectorJu
 */

/**
 * @create 2019-07-25 10:21
 * @desc test bite operate
 * '|' java 位或运算，只要有一个位置为1就是1，否则是0
 * 3 二进制是011
 * 9 二进制是01001
 * 结果是01011转换为十进制是11
 **/
package com.xlab.service_java_infrastructure.basic.biteoperate;

public class BiteSimulator {

    public static void main(String[] args) {
        System.out.println(3 | 9);
    }
}

