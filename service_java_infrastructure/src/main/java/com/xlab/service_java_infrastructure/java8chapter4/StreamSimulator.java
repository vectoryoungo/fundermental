/*
 * module: ${PROJECT_NAME}
 * file: ${FILE_NAME}
 * date: ${DATE}
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-18 11:25
 * @desc simulation of stream
 **/
package com.xlab.service_java_infrastructure.java8chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSimulator {

    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        //s.forEach(System.out::println); stream can only be consumed once

    }

}

