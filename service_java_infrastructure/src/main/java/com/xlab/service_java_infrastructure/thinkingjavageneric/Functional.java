/*
 * module: fundermental
 * file: Functional.java
 * date: 4/15/19 8:41 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-15 08:40
 * @desc test of generic with strategy pattern
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Functional {

    public static <T> T reduce(Iterable<T> seq,Combiner<T> combiner) {

        Iterator<T> iterator = seq.iterator();

        if (iterator.hasNext()) {
            T result = iterator.next();

            while (iterator.hasNext())
                result = combiner.combine(result,iterator.next());
            return result;
        }

        //If seq is empty list return null or throw exception
        return null;
    }


    public static <T> Collector<T> forEach(Iterable<T> seq,Collector<T> func){

        for (T t:seq){
            func.function(t);
        }
        return func;
    }

    public static<R,T> List<R> transform(Iterable<T> seq,UnaryFunction<R,T> func) {

        List<R> result = new ArrayList<R>();

        for (T t:seq) {
            result.add(func.function(t));
        }

        return result;
    }

    public static <T> List<T> filter(Iterable<T> seq,UnaryPredicate<T> pred) {

        List<T> result = new ArrayList<T>();

        for (T t:seq) {
            if (pred.test(t))
                result.add(t);
        }
        return result;
    }

    static class IntegerAdder implements Combiner<Integer> {
        @Override
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    static class IntegerSubtracter implements Combiner<Integer> {
        @Override
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }

    static class BigDecimalAdder implements Combiner<BigDecimal> {
        @Override
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    static class BigIntegerAdder implements Combiner<BigInteger> {
        @Override
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }

    static class AtomicLongAdder implements Combiner<AtomicLong> {
        @Override
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }

    static class BigDecimalUlp implements UnaryFunction<BigDecimal,BigDecimal>{
        @Override
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }

    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
        private T bound;
        public GreaterThan(T bound) {
            this.bound = bound;
        }

        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    static class MultiplyingIntegerCollector implements Collector<Integer> {
        private Integer val = 1;

        @Override
        public Integer function(Integer x) {
            val *= x;
            return val;
        }

        @Override
        public Integer result() {
            return val;
        }
    }

    public static void main(String[] args) {

        List<Integer> li = Arrays.asList(1,2,3,4,5,6,7);
        Integer result = reduce(li,new IntegerAdder());
        System.out.println("reduce List<Integer> Adder is " + result);

        result = reduce(li,new IntegerSubtracter());
        System.out.println("reduce List<Integer> Subtracter is " + result);

        System.out.println("reduce List<Integer> filter greater than is " + filter(li,new GreaterThan<Integer>(4)));

        System.out.println("foreach " + forEach(li,new MultiplyingIntegerCollector()).result());

        System.out.println("foreach filter " + forEach(filter(li,new GreaterThan<Integer>(4)),new MultiplyingIntegerCollector()).result());

        MathContext mathContext = new MathContext(7);

        List<BigDecimal> bigDecimalList = Arrays.asList(new BigDecimal(1.1,mathContext),new BigDecimal(2.2,mathContext)
                                                        ,new BigDecimal(3.3,mathContext),new BigDecimal(4.4,mathContext));
        BigDecimal bigDecimal = reduce(bigDecimalList,new BigDecimalAdder());
        System.out.println("after reduce is " + bigDecimal);

        System.out.println(filter(bigDecimalList,new GreaterThan<BigDecimal>(new BigDecimal(3))));

        List<BigInteger> bigIntegerList = new ArrayList<BigInteger>();

        BigInteger bigInteger = BigInteger.valueOf(11);
        for (int i=0;i<11;i++) {
            bigIntegerList.add(bigInteger);
            bigInteger = bigInteger.nextProbablePrime();
        }

        System.out.println("BigInteger list " + bigIntegerList);


        BigInteger bigInteger1 = reduce(bigIntegerList,new BigIntegerAdder());
        System.out.println("after for bigInteger1 " + bigInteger1);

        System.out.println(bigInteger1.isProbablePrime(5));

        List<AtomicLong> atomicLongList = Arrays.asList( new AtomicLong(11),new AtomicLong(47),new AtomicLong(74),new AtomicLong(133));
        AtomicLong atomicLong = reduce(atomicLongList,new AtomicLongAdder());
        System.out.println(atomicLong);

        System.out.println("transform " + transform(bigDecimalList,new BigDecimalUlp()));
    }

}

