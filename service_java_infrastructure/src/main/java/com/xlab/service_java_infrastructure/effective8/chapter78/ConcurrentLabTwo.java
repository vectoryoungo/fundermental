/*
 * module: fundermental
 * file: ConcurrentLabTwo.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

/*
 * module: fundermental
 * file: CocurrentLabTwo.java
 * date: 18-8-25 下午11:36
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-08-25 23:35
 * @desc with no stop
 **/
package com.xlab.service_java_infrastructure.effective8.chapter78;

public class ConcurrentLabTwo {

    private static volatile int nextSerialNumber =0;

    public static int generateSerialNumber() {
        return nextSerialNumber++;
    }

    public static void main(String[] args) {

    }
}

