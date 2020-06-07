/*
 * module: fundermental
 * file: ListHelper.java
 * date: 6/7/20 6:37 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-07 18:37
 * @desc 非线程安全的缺少即加入实现
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListHelper<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public synchronized boolean putIfAbsent(E x) {
//        synchronized (list) {
            boolean absent = !list.contains(x);

            if (absent) {
                list.add(x);
            }

            return absent;
//        }
    }
}

