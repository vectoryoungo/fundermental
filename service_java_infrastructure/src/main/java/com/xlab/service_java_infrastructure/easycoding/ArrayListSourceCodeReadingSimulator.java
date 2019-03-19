/*
 * module: fundermental
 * file: ArrayListSourceCodeReadingSimulator.java
 * date: 3/19/19 9:48 AM
 * author: VectorJu
 */

/**
 * @create 2019-03-19 09:47
 * @desc reading java collection source code
 **/
package com.xlab.service_java_infrastructure.easycoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ArrayListSourceCodeReadingSimulator {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>(3);
        list.add("one");
        list.add("two");
        list.add("three");

        //Object[] array1 = list.toArray();
        //System.out.println(" array1 size is " + array1.length);
        //String[] array2 = new String[2];
        //list.toArray(array2);
        //System.out.println(Arrays.asList(array2));

        //String[] array3 = new String[3];
        //list.toArray(array3);
        //System.out.println(Arrays.asList(array3));

        showDiffereceBetweenExtendsAndSuperGeneric();
    }


    /**
     * <? extends T> 是Get First 适用于消费集合元素为主的场景,可以赋值给任何T以及T子类的集合,T是上界。extends的场景是put功能受限。
     * <? super T></?>是Put First适用于生产集合元素为主的场景,可以赋值给任何T以及T的父类集合，T是下界。super的场景是get功能受限。
     */

    public static void showDiffereceBetweenExtendsAndSuperGeneric() {
        List<Animal> animals = new ArrayList<Animal>();
        List<Cat> cat = new ArrayList<Cat>();
        List<Garfield> garfields = new ArrayList<Garfield>();


        animals.add(new Animal());
        cat.add(new Cat());
        garfields.add(new Garfield());

        //Incompatible types
        //List<? extends Cat> extendsCatFromAnimal = animals;
        List<? super Cat> superCatFromAnimal = animals;

        List<? extends Cat> extendsCatFromCat = cat;
        List<? super Cat> superCatFromCat = cat;

        List<? extends Cat> extendsCatFromGarfield = garfields;


        //compile error Incompatible types
        //List<? super Cat> superCatFromGarfield = garfields;

        //type not correspond
        //extendsCatFromCat.add(new Animal());
        //extendsCatFromCat.add(new Cat());
        //extendsCatFromCat.add(new Garfield());

        //type not correspond
        //superCatFromCat.add(new Animal());
        superCatFromCat.add(new Cat());
        superCatFromCat.add(new Garfield());


        Object catExtends2 = extendsCatFromCat.get(0);
        Cat catExtends1 = extendsCatFromCat.get(0);

        System.out.println("catExtends2 " + catExtends2);
        System.out.println("catExtends1 " + catExtends1);
        //Incompatible types
        //Garfield garfield1 = extendsCatFromGarfield.get(0);

    }
}

