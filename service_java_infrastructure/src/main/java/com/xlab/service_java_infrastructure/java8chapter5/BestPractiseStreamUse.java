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

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class BestPractiseStreamUse {

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
    }
}

