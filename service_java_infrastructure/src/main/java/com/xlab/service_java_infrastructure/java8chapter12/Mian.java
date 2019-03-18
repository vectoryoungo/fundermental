/*
 * module: fundermental
 * file: Mian.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

/**
 * @author juhongtao
 * @create 2018-07-27 16:03
 * @desc ste
 **/
package com.xlab.service_java_infrastructure.java8chapter12;

import java.math.BigInteger;
import java.util.UUID;

public class Mian {
    public static void main(String[] args) {
        String a = "199.0";
        Double doubl = Double.parseDouble(a);
        System.out.println(doubl.intValue());



       /* Long longs = Long.parseLong("199.0",3);
        Number number = (Number) longs;
        System.out.println(number);
        BigInteger bigInteger = new BigInteger("177.0",10);
        System.out.println(bigInteger);*/
        System.out.println(UUID.randomUUID().toString());

        int number = 2;
        if (number<2) {
            System.out.println("insert block record ");

        }else if (number>=1) {
            System.out.println("update block record");

        }


        Long lnumber = 192165296742731781l;
        System.out.println("normal num " + lnumber);
        System.out.println("max number " + Long.MAX_VALUE);
        System.out.println("min number " + Long.MIN_VALUE);
    }
}

