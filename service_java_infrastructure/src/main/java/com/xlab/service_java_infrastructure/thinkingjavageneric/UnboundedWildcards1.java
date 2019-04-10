/*
 * module: fundermental
 * file: UnboundedWildcards1.java
 * date: 4/10/19 9:15 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 09:15
 * @desc test of generic
 * test of no limit wildcard
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcards1 {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;

    static void assign1(List list) {
        list1 = list;
        list2 = list;
        list3 = list;// according thinking in java fourth edition this will lead unchecked conversion but in java8 is not
        System.out.println("assign1 is ok ");
    }

    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
        System.out.println("assign2 is ok ");
    }

    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
        System.out.println("assign3 is ok ");
    }

    public static void main(String[] args) {
        assign1(new ArrayList());
        assign2(new ArrayList<>());
        assign3(new ArrayList<>());//according thinkin in java fourth edition this will lead unchecked conversion but in java8 is not

        assign1(new ArrayList<String>());
        assign2(new ArrayList<String>());
        assign3(new ArrayList<String>());

        List<?> wildList = new ArrayList();
        wildList = new ArrayList<String>();
        assign1(wildList);
        assign2(wildList);
        assign3(wildList);
    }
}

