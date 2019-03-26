/*
 * module: fundermental
 * file: ArrayListSourceCodeReadingSimulator.java
 * date: 3/19/19 9:48 AM
 * author: VectorJu
 */

/**
 * @create 2019-03-19 09:47
 * @desc reading java collection source code
 *
 * java.lang.String.valueOf(Math.random()))
 *
 *
 *
 **/
package com.xlab.service_java_infrastructure.easycoding;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListSourceCodeReadingSimulator  extends Thread{

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>(3);
        list.add("one");
        list.add("two");
        list.add("three");
        showDiffereceBetweenExtendsAndSuperGeneric();
        //Object[] array1 = list.toArray();
        //System.out.println(" array1 size is " + array1.length);
        //String[] array2 = new String[2];
        //list.toArray(array2);
        //System.out.println(Arrays.asList(array2));

        //String[] array3 = new String[3];
        //list.toArray(array3);
        //System.out.println(Arrays.asList(array3));

        //showDiffereceBetweenExtendsAndSuperGeneric();

        /*showComparable();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        showComparator();
        System.out.println("equals or not " + Objects.equals(new Animal(),new Animal()));
        ArrayListSourceCodeReadingSimulator arrayListSourceCodeReadingSimulator = new ArrayListSourceCodeReadingSimulator();
        arrayListSourceCodeReadingSimulator.start();
        arrayListSourceCodeReadingSimulator.concurrentHashMapNPE();
        Map map;
        TreeMap treeMap;*/
        HashMap hashMap = new HashMap();
        hashMap.put("slot1",new Animal());
        /*CopyOnWriteArrayList<Double> copyOnWriteArrayList = new CopyOnWriteArrayList<Double>();


        for (int i=0;i<1000;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("CURRENT " + Thread.currentThread().getName());
                    System.out.println(" PRIORITY " + Thread.currentThread().getPriority());
                    //System.out.println("CURRENT ID " + Thread.currentThread().getId());
                    copyOnWriteArrayList.add(Math.random());
                }
            }).start();
        }*/

        /*for (Double doule:copyOnWriteArrayList) {
            System.out.println(" double value is " + doule);
        }*/
    }


    /**
     * <? extends T>是Get First 适用于消费集合元素为主的场景,可以赋值给任何T以及T子类的集合,T是上界。extends的场景是put功能受限。
     * <? super T>是Put First适用于生产集合元素为主的场景,可以赋值给任何T以及T的父类集合，T是下界。super的场景是get功能受限。
     * 对于一个容器如果只是不断地向外取动物而不向里放的话，则属于Get First.应采用<? extends T>
     * 相反；如果经常向容器里放动物的话应采用<? super T>属于put first
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

        Cat catGet1 = (Cat) superCatFromCat.get(0);
        Garfield catGet2 = (Garfield)superCatFromCat.get(1);// this is illegal and will cause ClassCastException
        System.out.println("catGet1 " + catGet1);
        //hashMap.put();
        //System.out.println("caatGet2 " +catGet2);
        //Incompatible types
        //Garfield garfield1 = extendsCatFromGarfield.get(0);

    }

    //this function is show how to compare two same type
    public static void showComparable() {

        System.out.println("now start showComparable");
        SearchResult searchResult = new SearchResult(55,88);
        searchResult.setRecentOrderders(100000);

        SearchResult searchResult1 = new SearchResult(66,99);
        searchResult1.setRecentOrderders(200000);

        System.out.println(" two search object compare result is " + searchResult.compareTo(searchResult1));
        System.out.println("now end showComparable");
    }

    //this function is show compare with adapt
    public static void showComparator() {
        System.out.println("now start showComparator ");
        SearchResultComparator searchResultComparator = new SearchResultComparator();

        SearchResult searchResult = new SearchResult(77,55);
        searchResult.setRecentOrderders(6666);

        SearchResult searchResultDuplicate = new SearchResult(44,99);
        searchResultDuplicate.setRecentOrderders(88888);

        System.out.println(" searchResult compare searchResultDuplicate result is " + searchResultComparator.compare(searchResult,searchResultDuplicate));
        System.out.println("now end showComparator");
    }

    public void concurrentHashMapNPE() {
        ConcurrentHashMap<Object,Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>();
        concurrentHashMap.put("man",null);

        String result = (String) concurrentHashMap.get("man");
        System.out.println(result);

    }
}

