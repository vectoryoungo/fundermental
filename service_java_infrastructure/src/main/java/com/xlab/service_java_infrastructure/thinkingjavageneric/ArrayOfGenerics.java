/*
 * module: fundermental
 * file: ArrayOfGenerics.java
 * date: 4/16/19 8:41 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-16 08:41
 * @desc test of array generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] stringGenericsList;
        List[] originList = new List[10];
        stringGenericsList = (List<String>[]) originList;
        System.out.println("string generic list size is " + stringGenericsList.length);

        stringGenericsList[0] = new ArrayList<String>();
        System.out.println("stringGenericsList[0]" + stringGenericsList[0]);
        //stringGenericsList[1] = new ArrayList<Integer>();
        Object[] objects = stringGenericsList;
        System.out.println("objects size is " + objects.length);
        System.out.println("class type " + objects.getClass().getTypeName());
        System.out.println("class simple name " + objects.getClass().getSimpleName());
        System.out.println("class is " + objects.getClass());


    }

}

