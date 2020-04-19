/*
 * module: fundermental
 * file: SoftReferenceSimulator.java
 * date: 4/19/20 3:30 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-19 15:30
 * @desc 测试软引用的场景.软引用主要是用作缓存.
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.lang.ref.SoftReference;

public class SoftReferenceSimulator {

    public static void main(String[] args) {

        SoftReference<byte[]> softReferenceByte = new SoftReference<byte[]>(new byte[1024*1024*10]);

        System.out.println(softReferenceByte.get());
        System.gc();
        try {
            Thread.sleep(500);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(softReferenceByte.get());
        byte[] restore = new byte[1024*1024*15];
        System.out.println(softReferenceByte.get());


    }
}

