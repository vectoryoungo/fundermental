/*
 * module: fundermental
 * file: SuperTypeWildCards.java
 * date: 4/9/19 5:22 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 17:22
 * @desc supertype
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

import java.util.ArrayList;
import java.util.List;

public class SuperTypeWildCards {

    static void writeToGeneric(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        System.out.println(apples.get(0));
        System.out.println(apples.get(1));
    }

    public static void main(String[] args) {
        List<? super Apple> apples = new ArrayList<Apple>(10);
        writeToGeneric(apples);
    }
}

