/*
 * module: fundermental
 * file: SoftReferenceHouse.java
 * date: 3/29/19 2:47 PM
 * author: VectorJu
 */

/**
 * @create 2019-03-29 14:47
 * @desc SoftReferenceHouse
 **/
package com.xlab.service_java_infrastructure.easycoding;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceHouse {

    public static void main(String[] args) {
        List<SoftReference> houses = new ArrayList<SoftReference>();

        int i =0;
        /*while (true) {
            //houses.add(new House());
            SoftReference<House> buyer2 = new SoftReference<House>(new House());
            houses.add(buyer2);
            System.out.println("i=" + (++i));
        }*/

        for(int j=0;j<100;j++){
            SoftReference<House> buyer2 = new SoftReference<House>(new House());
            houses.add(buyer2);
            System.out.println("j=" + (++j));
        }

        System.out.println("end");
    }
}

class House {

    private static final Integer DOOR_NUMBER = 2000;
    public Door[] doors = new Door[DOOR_NUMBER];

    class Door {}
}

