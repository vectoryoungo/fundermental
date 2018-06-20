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
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
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
                comparingInt(Dish::getCalories);
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

        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l; },
                        (List<Integer> l1, List<Integer> l2) -> {
            l1.addAll(l2);
            return l1; });

        int totalCaloriesWithoutCollect =
                menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println("without collect get all calories " + totalCaloriesWithoutCollect);
        //most simplify way is mapped stream to a IntStream
        int totalCaloriesSimplify = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("most simplify way is mapped stream to a IntStream " + totalCaloriesSimplify);

        //base condition best plan
        //group dish by type
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(" dish type " + dishesByType);
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return
                            CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                } ));
        System.out.println(" calories group by " + dishesByCaloricLevel);
        //combination group by
        //multi grade group by
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                } )
                        )
                );
        System.out.println(" multi grade group by " + dishesByTypeCaloricLevel);

        //statistic how many dished in different type menu
        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting()));
        System.out.println("different type dishes contains how many dished " + typesCount);

        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                maxBy(comparingInt(Dish::getCalories))));
        System.out.println("find menu's most calories and group by type " + mostCaloricByType);

        //convert collect result into other type use Collectors.collectingAndThen
        Map<Dish.Type, Dish> mostCaloricByTypeReturnOtherType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));
        System.out.println(" convert collect result into other type " + mostCaloricByTypeReturnOtherType);

        //other collect tools use with group by
        Map<Dish.Type, Integer> totalCaloriesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));
        System.out.println(" group by type and calculate each group summarization " + totalCaloriesByType);

        //和group by 一起用的mapping 对于每种类型的Dish，
        //菜单中都有哪些CaloricLevel我们可以把groupingBy和mapping收集器结合起来
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                                dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                else return CaloricLevel.FAT; },
                                toSet() )));
        System.out.println(caloricLevelsByType);

        //对于返回的Set是什么类型并没有任何保证。但通过使用toCollection，你就可
        //以有更多的控制。
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByTypeCollection =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                                dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                else return CaloricLevel.FAT; },
                                toCollection(HashSet::new) )));
        System.out.println(caloricLevelsByTypeCollection);

        //6.4 分区
        //把菜单按照素食和非素食分开
        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);
        //通过Map中键为true的值，就可以找出所有的素食菜肴
        List<Dish> vegetarianDishes = partitionedMenu.get(true);
        //List同样也可以做到
        List<Dish> vegetarianDishesListVersion =
                menu.stream().filter(Dish::isVegetarian).collect(toList());

        //使用两个筛选操作来访问partitionedMenu这个Map中false
        //键的值：一个利用谓词，一个利用该谓词的非。而且就像你在分组中看到的，partitioningBy
        //工厂方法有一个重载版本，可以像下面这样传递第二个收集器
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType);
        //重用前面的代码来找到素食和非素
        //食中热量最高的菜：
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));
        System.out.println("素食和非素食中热量最高的菜：" + mostCaloricPartitionedByVegetarian);
        //将数字按质数和非质数分区


    }
}

