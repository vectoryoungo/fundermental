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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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

    /**
     *
     * @param numbers
     * @param showNum
     * @param index
     */
    private static void show(double[] numbers,int showNum,int index) {
        long start = System.currentTimeMillis();
        double[] copyNumber = numbers;
        System.out.println("element is " + copyNumber[index]);
        //System.out.println(" number is " + showNum);
        System.out.println("takes " + (System.currentTimeMillis()-start));
    }

    public static void main(String[] args) {
        /*long start = System.currentTimeMillis();
        String result = intern("thisisshitaboutchinesegovernment");
        System.out.println("it takes " + (System.currentTimeMillis() - start));
        System.out.println("max " + Long.MAX_VALUE);

        String str = "BTC" + "_"+"ETH";
        System.out.println(str.toLowerCase());*/

       /* long time = System.currentTimeMillis();
        int[] numbers = {1,2,3,55,88,44,66,11};
        int num = 998;
        System.out.println("num " + num);*/
        //System.out.println(numbers[4]);

        /*double[] numbers = {1,2,3,55,88,44,66,11,112,43,12,345,564,234,123,435,56,22,123,123,12,345,356,23,123,123,3453,45,657,5,675,67,56,123123,2567567};
        *//*System.out.println("length " + numbers.length);
        show(numbers,88,33);*//*
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(Double.valueOf(55));
        doubleList.add(Double.valueOf(88));
        doubleList.add(Double.valueOf(44));
        doubleList.add(Double.valueOf(66));
        doubleList.add(Double.valueOf(112));
        doubleList.add(Double.valueOf(43));
        doubleList.add(Double.valueOf(345));
        doubleList.add(Double.valueOf(435));
        doubleList.add(Double.valueOf(56));
        doubleList.add(Double.valueOf(356));

        Iterator iterator = doubleList.iterator();
        while (iterator.hasNext()) {
            Double con = (Double) iterator.next();
            if (con.equals(Double.valueOf(112)))
            {
                continue;
            }
            System.out.println("content " + con);
        }*/

       /* String address = "mvXeUEjQ6BU1QJnHJDMPxrGnmfyBcfv7Qu";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("'");
        stringBuilder.append("[");
        stringBuilder.append("\"");
        stringBuilder.append(address);
        stringBuilder.append("\"");
        stringBuilder.append("]");
        stringBuilder.append("'");
        System.out.println("content " + stringBuilder.toString());

        String str = "";
        str = null;

        if ("".equals(str)) {
            System.out.println(" null character ");
        }

        for (int i=0;i<10;i++){
            try {
                if (i%5==0) {
                    int result = i/0;
                }
            }catch (Exception e) {
                System.out.println("errrr");
            }
            System.out.println(" i = " + i);
        }*/


        String amount = "2312.2342BTC";
        String str = amount.substring(0,amount.indexOf("."));
        System.out.println(str);

    }
}

