/*
 * module: fundermental
 * file: CaptureConversion.java
 * date: 4/10/19 11:35 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 11:35
 * @desc test of capture conversion
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class CaptureConversion {

    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder);
        System.out.println("f2 is ok");
        System.out.println(holder.getClass().getTypeName());
        System.out.println(holder.getClass());
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        f1(raw);//according to thinking in java fourth edition this will lead warning but in java8 mac is not
        f2(raw);
        Holder rawBasic = new Holder();
        rawBasic.set(new Object());//according to thinking in java fourth edition this will lead warning but in java8 mac is not
        f2(rawBasic);
        Holder<?> wildcarded = new Holder<Double>(1.0);
        f2(wildcarded);
    }
}

