/*
 * module: fundermental
 * file: Wildcards.java
 * date: 4/10/19 9:42 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 09:41
 * @desc 编译器何时才会关注原生类型和涉及无界通配符的类型之间的差异
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

import java.time.LocalDateTime;

public class Wildcards {

    static void rawArgs(Holder holder,Object arg) {
        //holder.set(arg);this is no warning
        //holder.set(new Wildcards());

        //can't do this; don't have any 'T'
        //T t = holder.get();

        Object object = holder.get();
        System.out.println(" rawArgs this is ok ");
    }

    static void unboundedArg(Holder<?> holder,Object arg) {
        //holder.set(arg);// this is illegal
        //holder.set(new Wildcards());// this is illegal
        Object object = holder.get();
        System.out.println(" unboundedArg this is ok ");
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder,T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubType(Holder<? extends T> holder,T arg) {
        //holder.set(arg);// this is illegal
        T t = holder.get();

        return t;
    }

    static <T> void wildSuperType(Holder<? super T> holder,T arg) {
        holder.set(arg);
        T t = (T) holder.get();// this need force cast

        Object object = holder.get();
        System.out.println(" wildSyperType this is ok ");
    }

    public static void main(String[] args) {

        Holder raw = new Holder<Long>();
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bouned = new Holder<Long>();
        Long lng = 1L;
        rawArgs(raw,lng);
        rawArgs(qualified,lng);
        rawArgs(unbounded,lng);
        rawArgs(bouned,lng);

        unboundedArg(raw,lng);
        unboundedArg(qualified,lng);
        unboundedArg(unbounded,lng);
        unboundedArg(bouned,lng);

        //Object object = exact1(raw);//according thinking in java this will lead warning but in java8 mac is not
        Long lo1 = exact1(qualified);
        Long ll = (Long) exact1(unbounded);// force cast
        Object o = exact1(unbounded);// this can be bounded
        Long boundedLong = exact1(bouned);
        Long long5 = exact2(raw,lng);//according thinking in java fourth edition this will lead unchecked conversion but in java8 mac is not
        Long long6 = exact2(qualified,lng);

        //Long long7 = exact2(unbounded,lng);// this is error
        //Long long8 = exact2(bouned,lng);// this is error the same as long7

        Long long9 = wildSubType(raw,lng);//according
    }
}

