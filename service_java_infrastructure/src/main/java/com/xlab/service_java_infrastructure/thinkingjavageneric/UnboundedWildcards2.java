/*
 * module: fundermental
 * file: UnboundedWildcards2.java
 * date: 4/10/19 9:32 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 09:31
 * @desc 测试在处理多个泛型参数时，有时允许一个参数可以使任何类型，同时为其他参数确定某种特定类型的这种能力显得很重要
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

import java.util.HashMap;
import java.util.Map;

public class UnboundedWildcards2 {
    static Map map1;
    static Map<?,?> map2;
    static Map<String,?> map3;
    static void assign1(Map map){
        map1 = map;
        System.out.println("assign1 is ok ");
    }

    static void assign2(Map<?,?> map) {
        map2 = map;
        System.out.println("assign2 is ok ");
    }

    static void assign3(Map<String,?> map) {
        map3 = map;
        System.out.println("assign3 is ok ");
    }

    public static void main(String[] args) {
        assign1(new HashMap());
        assign2(new HashMap<>());
        assign3(new HashMap<>());//according to thinking in java fourth edition this will lead warning unchecked conversion but in java8 mac is not
        assign1(new HashMap<String,Integer>());
        assign2(new HashMap<String,Integer>());
        assign3(new HashMap<String,Integer>());
    }
}

