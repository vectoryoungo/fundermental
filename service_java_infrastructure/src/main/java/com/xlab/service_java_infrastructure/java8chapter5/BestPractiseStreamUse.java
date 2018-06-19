/*
 * module: ${PROJECT_NAME}
 * file: ${FILE_NAME}
 * date: ${DATE}
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-18 16:09
 * @desc best use of stream
 **/
package com.xlab.service_java_infrastructure.java8chapter5;

import com.xlab.service_java_infrastructure.java8chapter4.Dish;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class BestPractiseStreamUse {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //find all transaction in 2011
        transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(toList());

        //find trader liver in city
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(toList());

        //use set replace map
        Set<String> cities =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .collect(toSet());

        //search all trader from bridge and sort by alphabet
        List<Trader> traderList = transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge")).distinct().sorted(comparing(Trader::getName)).collect(toList());
        for (Trader trader:traderList) {
            System.out.println(trader);
        }

        //return trader name order by alphabet
        String finalString = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().reduce("",(name1,name2)->name1+name2);
        System.out.println(" ordered is " + finalString);
        //high efficiency
        String traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(joining());
        System.out.println("trade string " + traderStr);

        //write by vector ju
        List<Trader> millanTrader = transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Milan")).collect(toList());
        for (Trader trader:millanTrader) {
            System.out.println(" millan trader " + trader);
        }
        //example in book
        boolean milanBased =
                transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                .getCity()
                                .equals("Milan"));
        System.out.println("is trader work in milan " + milanBased);

        //print trader live in cambridge's transaction value
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).forEach(System.out::println);
        // all transaction's most high value
        Optional<Integer> integer = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println("most high value " + integer);
        // all transaction's least value
        Optional<Integer> integerOptional = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
        System.out.println("least value " + integerOptional);

        //transaction value's least
        Optional<Transaction> smallestTransaction =
                transactions.stream()
                        .reduce((t1, t2) ->
                                t1.getValue() < t2.getValue() ? t1 : t2);

        //efficiency
        Optional<Transaction> smallestTransactions =
                transactions.stream()
                        .min(comparing(Transaction::getValue));

       //data value stream
        long startCaloriesCalculate = System.currentTimeMillis();
        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("calories is " + calories);
        System.out.println(" calories without optimized is " + (System.currentTimeMillis() - startCaloriesCalculate));

        //mapped to data value stream
        long startCaloriesWithOptimized = System.currentTimeMillis();
        int caloriesOptimized = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("optimized data value " + caloriesOptimized);
        System.out.println(" optimized data value takes " + (System.currentTimeMillis() - startCaloriesWithOptimized));
        //convert back to object stream
        //it means convert raw stream to a normal stream
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        stream.forEach(integer1 -> {
            System.out.println("value of stream content is " + integer1);
        });

        //how to distinct no element stream and the biggest value is 0 stream
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println("optional max " + maxCalories.getAsInt());
        //process without value
        maxCalories.orElse(1);

        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println("after filter " + evenNumbers.count());
        //filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
        System.out.println(Math.sqrt(8));
        System.out.println(Math.sqrt(4));
        /*IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});*/
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                        );
        pythagoreanTriples.limit(5)
                .forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
        Stream<double[]> pythagoreanTriples2 =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .mapToObj(
                                                b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
                                        .filter(t -> t[2] % 1 == 0));
        pythagoreanTriples2.limit(10).forEach(t-> System.out.println("after optimized " + t[0] + ", " + t[1] + ", " + t[2]));

        //from value to create unLimit stream
        Stream<String> streamAlphabet = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        streamAlphabet.map(String::toUpperCase).forEach(System.out::println);
        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(string-> System.out.println("empty String " + string));

        //create stream from array
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(" array sum is " + sum);

        //create stream from a file
        long uniqueWords = 0;
        try(Stream<String> lines =
                    Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println(" unique words " + uniqueWords);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        //generate stream from a function
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}

