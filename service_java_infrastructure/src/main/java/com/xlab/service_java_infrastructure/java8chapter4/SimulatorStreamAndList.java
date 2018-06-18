/*
 * module: ${PROJECT_NAME}
 * file: ${FILE_NAME}
 * date: ${DATE}
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-18 11:44
 * @desc simulator list
 **/
package com.xlab.service_java_infrastructure.java8chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SimulatorStreamAndList {

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

        List<String> names =
                menu.stream()
                        .filter(d -> {
                            System.out.println("filtering:" + d.getName());
                            return d.getCalories() > 300;
                        })
                        .map(d -> {
                            System.out.println("mapping:" + d.getName());
                            return d.getName();
                        })
                        .limit(3)
                        .collect(toList());
        System.out.println(names);

        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
        for (Dish dish:dishes) {
            System.out.println(dish);
        }

        //filter meat dishes
        List<Dish> dishesMeat =
                menu.stream()
                        .filter(d -> d.getType() == Dish.Type.MEAT)
                        .limit(2)
                        .collect(toList());
        for (Dish dish:dishesMeat){
            System.out.println(dish);
        }

        //give specific words and calculate it's length
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        for (Integer integer:wordLengths) {
            System.out.println(" length is " + integer);
        }

        //find dishes name length
        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        for (Integer lenght:dishNameLengths) {
            System.out.println("dish name's length is " + lenght);
        }

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        List<Stream<String>> wordsList = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());
        List<String> uniqueCharacters =
                words.stream()
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());

        for (String string:uniqueCharacters) {
            System.out.println("unique characters " + string);
        }

        //give a number list and return it's
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares =
                numbers.stream()
                        .map(n -> n * n)
                        .collect(toList());
        for (Integer integer:squares) {
            System.out.println(" number's squares is " + integer);
        }

        //give two number list and return number pairs
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        for (int[] ints:pairs) {
            for (int num:ints){
                System.out.println("ints is " + num);
            }
        }

        //base on upon and return sum can be divided by 3
        List<Integer> numbers1C = Arrays.asList(1, 2, 3);
        List<Integer> numbers2C = Arrays.asList(3, 4);
        List<int[]> pairsC =
                numbers1.stream()
                        .flatMap(i ->
                                numbers2C.stream()
                                        .filter(j -> (i + j) % 3 == 0)
                                        .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        for (int[] ints:pairsC){
            for (int num:ints){
                System.out.println("can be divided is " + num);
            }
        }
    }
}

