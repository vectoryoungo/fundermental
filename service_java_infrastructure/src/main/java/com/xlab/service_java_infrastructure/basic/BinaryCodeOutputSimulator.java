/*
 * module: fundermental
 * file: BinaryCodeOutputSimulator.java
 * date: 3/22/20 9:58 AM
 * author: VectorJu
 */

/**
 * @create 2020-03-22 09:57
 * @desc 输出一个数的二进制和移位后的二进制数据
 **/
package com.xlab.service_java_infrastructure.basic;

public class BinaryCodeOutputSimulator {

    public static void main(String[] args) {
        int eleven = new Integer(11);
        System.out.println(" before right move 16  11 binary code is "+Integer.toBinaryString(eleven));
        int result = eleven>>>16;
        System.out.println(" after right move 16 result is "+Integer.toBinaryString(result));
        int leftMove = eleven<<16;
        System.out.println(" after left move 16 result is "+Integer.toBinaryString(leftMove));

    }
}

