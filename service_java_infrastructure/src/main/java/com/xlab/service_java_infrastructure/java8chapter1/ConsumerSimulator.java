/*
 * module: ${PROJECT_NAME}
 * file: ${FILE_NAME}
 * date: ${DATE}
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-17 16:17
 * @desc simulation of consumer
 **/
package com.xlab.service_java_infrastructure.java8chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConsumerSimulator {


    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T i: list){
            c.accept(i);
        }
    }

    public static void main(String[] args) {
        forEach(
                Arrays.asList(1,2,3,4,5),
                (Integer i) -> System.out.println(i)
        );

        Function<String, Integer> stringToInteger =
                (String s) -> Integer.parseInt(s);
        Function<String, Integer> stringToIntegerImprove = Integer::parseInt;
        System.out.println(stringToIntegerImprove.toString());
    }
}

