/*
 * module: ${PROJECT_NAME}
 * file: ${FILE_NAME}
 * date: ${DATE}
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-21 08:21
 * @desc simulation of parallet stream use
 **/
package com.xlab.service_java_infrastructure.java8chapter7;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamSimulator {

    //接受数字n作为参数，并返回从1到给定参数的所有数字的和，花费时间第一次128毫秒 corei7 四核 16G 256 solid disk
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    //传统的java循环方式 第一次运行花费时间1毫秒  corei7 四核 16G 256 solid disk
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    //并行流计算corei7 四核 16G 256 solid disk 第一次运行95毫秒花费
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    //可能以为把这两个方法结合起来，就可以更细化地控制在遍历流时哪些操作要并行执行，哪些要
    //顺序执行。
    /**
     *
     * stream.parallel()
     * .filter(...)
     * .sequential()
     * .map(...)
     * .parallel()
     * .reduce();
     * 但最后一次parallel或sequential调用会影响整个流水线。在本例中，流水线会并行执
     * 行，因为最后调用的是它。
     * **/

    //测量对前n个自然数求和的函数的性能
    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    //LongStream.rangeClosed的方法代替iterator,LongStream.rangeClosed直接产生原始类型的long数字，没有装箱拆箱的开销
    //LongStream.rangeClosed会生成数字范围，很容易拆分为独立的小块。例如，范围1~20可分为1~5、6~10、11~15和16~20。
    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    //并行流版本的没有装箱拆箱的
    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }


    public static void main(String[] args) {
        //long start = System.currentTimeMillis();
        //long result = iterativeSum(1000);
        //System.out.println("result " + result);
        //System.out.println(" it takes " + (System.currentTimeMillis()-start) + " million seconds");

        System.out.println("Sequential sum done in:" +
                measureSumPerf(ParallelStreamSimulator::sequentialSum, 10_000_000) + " msecs");
        System.out.println("Iterative sum done in:" +
                measureSumPerf(ParallelStreamSimulator::iterativeSum, 10_000_000) + " msecs");
        System.out.println("Parallel sum done in: " +
                measureSumPerf(ParallelStreamSimulator::parallelSum, 10_000_000) + " msecs" );//此处并行反而更慢，
        // 因为iterate生成的是装箱的对象，必须拆箱成数字才能求和，我们很难把iterate分成多个独立块来并行执行。这意味着，在这个特定情况下
        //整张数字列表在归纳过
        //程开始时没有准备好，因而无法有效地把流划分为小块来并行处理。把流标记成并行，你其实是
        //给顺序处理增加了开销，它还要把每次求和操作分到一个不同的线程上
        System.out.println("LongStream sum done in: " + measureSumPerf(ParallelStreamSimulator::rangedSum,10_000_000)+ " msecs" );
        System.out.println("Parallel range sum done in:" +
                measureSumPerf(ParallelStreamSimulator::parallelRangedSum, 10_000_000) +
                " msecs");

        System.out.println("SideEffect parallel sum done in: " + measureSumPerf(ParallelStreamSimulator::sideEffectParallelSum, 10_000_000L) +"msecs" );
        System.out.println("ForkJoin sum done in: " + measureSumPerf(
                ForkJoinSumCalculator::forkJoinSum, 10_000_000) + " msecs" );
    }

    //本质上就是顺序的。每
    //次访问total都会出现数据竞争。如果你尝试用同步来修复，那就完全失去并行的意义了
    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    //并行版本
    //每次执行都会返回不同的结果，都离正确值
    //50000005000000差很远。这是由于多个线程在同时访问累加器，执行total += value，而这
    //一句虽然看似简单，却不是一个原子操作。问题的根源在于，forEach中调用的方法有副作用，
    //它会改变多个线程共享的对象的可变状态。要是你想用并行Stream又不想引发类似的意外，就
    //必须避免这种情况。
    //Result: 11021106057211
    //Result: 8189786188194
    //Result: 15524859939398
    //Result: 6744529672156
    //Result: 9384901657904
    //Result: 7438031247082
    //Result: 7105082062443
    //Result: 5481882028017
    //Result: 9028509574975
    //Result: 6025314934521
    // 记住要避免共享可变状态

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

}

