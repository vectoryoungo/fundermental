/**
 * @create 2020-06-08 22:48
 * @desc
 **/
package com.xlab.service_java_infrastructure.concurrent;

public class TestHarnessSimulator {

    public static void main(String[] args) {

//        TestHarness testHarness = new TestHarness();
//        try {
//            long takes = testHarness.timeTasks(10,new MyThread(1,1));
//            System.out.println("takes " + takes);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        BoundedHashSet<Integer> boundedHashSet = new BoundedHashSet<>(1);

        try {
            boolean added = boundedHashSet.add(5);
            System.out.println(added);
            boolean addedT = boundedHashSet.add(4);
            System.out.println(addedT);
            boolean removed = boundedHashSet.remove(4);
            System.out.println(removed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

