/*
 * module: fundermental
 * file: SelfBounding.java
 * date: 4/10/19 4:25 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 16:25
 * @desc test of selfbounding
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class SelfBounding {

    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
        System.out.println(a);
        C c = new C();
        c = c.setAndGet(c);
        System.out.println(c);
    }
}

