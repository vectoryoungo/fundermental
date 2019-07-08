/*
 * module: fundermental
 * file: TreeMapTestor.java
 * date: 7/8/19 8:27 AM
 * author: VectorJu
 */

/**
 * @create 2019-07-08 08:27
 * @desc test sort treemap
 **/
package com.xlab.service_java_infrastructure.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class TreeMapTestor {

    private static void simulate(List<TreeMap<String,Integer>> tradeMap) {


        for (TreeMap<String,Integer> price:tradeMap) {
            if (null != price.get("price")) {
                System.out.println("price " + price.get("price"));
            }

            /*if (null != price.get("amount")) {
                System.out.println("amount " + price.get("amount"));
            }*/
        }
    }

    public static void main(String[] args) {

        List<TreeMap<String,Integer>> container = new ArrayList<>(128);
        Random random = new Random(100);
        for (int i=0;i<100;i++) {

            TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>();

            if (i%2==0){

                treeMap.put("price",random.nextInt());
            }else if (i%3==0){
                treeMap.put("amount",i);
            }

            container.add(treeMap);
        }

        simulate(container);

    }
}

