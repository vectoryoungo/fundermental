/*
 * module: fundermental
 * file: Holder3.java
 * date: 4/7/19 5:39 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-07 17:39
 * @desc generic holder
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class Holder3<T> {

    private T t;
    public Holder3(T t) {
        this.t = t;
    }

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Holder3<Automobile> holder3 = new Holder3<Automobile>(new Automobile());
        Automobile automobile = holder3.get();
        System.out.println(automobile);
        //holder3.set("thisisillegal");
    }
}

