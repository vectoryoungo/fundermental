/*
 * module: ${PROJECT_NAME}
 * file: ${FILE_NAME}
 * date: ${DATE}
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-19 18:16
 * @desc demonstrate collect data with stream
 **/
package com.xlab.service_java_infrastructure.java8chapter6;

import com.xlab.service_java_infrastructure.java8chapter4.Dish;
import com.xlab.service_java_infrastructure.java8chapter5.Trader;
import com.xlab.service_java_infrastructure.java8chapter5.Transaction;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollectDataWithStream {

    public static void main(String[] args) {
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
        long howManyDishes = menu.stream().collect(Collectors.counting());
        //or we can write like this
        long dishes = menu.stream().count();
        System.out.println(" how many " + howManyDishes);
        System.out.println("dishes " + dishes);

        //search stream's biggest and least value
        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish =
                menu.stream()
                        .collect(maxBy(dishCaloriesComparator));
        System.out.println("optional content " + mostCalorieDish.get());

        //Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream().collect(groupingBy(Transaction::getValue));
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("total calories " + totalCalories);

        //average calories
        double avgCalories =
                menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println("average " + avgCalories);
        IntSummaryStatistics menuStatistics =
                menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println("short menu " + shortMenu);

    }
}

