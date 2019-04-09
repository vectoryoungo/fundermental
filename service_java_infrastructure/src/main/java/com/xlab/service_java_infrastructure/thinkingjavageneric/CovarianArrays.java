/*
 * module: fundermental
 * file: CovarianArrays.java
 * date: 4/9/19 3:57 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 15:57
 * @desc test of arrays
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class CovarianArrays {

    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];

        fruits[0] = new Apple();
        fruits[1] = new Jonathan();

        try {
            fruits[0] = new Fruit();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            fruits[0] = new Orange();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

