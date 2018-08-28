/*
 * module: fundermental
 * file: SimulatorConcurrentMap.java
 * date: 18-8-28 下午5:51
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-08-28 17:50
 * @desc test concurrent canonicaling map
 **/
package com.xlab.service_java_infrastructure.effective8.chapter81;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SimulatorConcurrentMap {

    private static final ConcurrentMap<String,String> map = new ConcurrentHashMap<>();

    public static String intern(String s) {

        String previousValue = map.putIfAbsent(s,s);
        return previousValue == null?s:previousValue;
    }

    //optimize
    public static String internOptimize(String s) {
        String result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s,s);
            if (result == null) {
                result = s;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String result = intern("thisisshitaboutchinesegovernment");
        System.out.println("it takes " + (System.currentTimeMillis() - start));
    }
}

