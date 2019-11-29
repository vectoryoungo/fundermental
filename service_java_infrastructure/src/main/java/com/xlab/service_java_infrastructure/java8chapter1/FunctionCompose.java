/*
 * module: fundermental
 * file: FunctionCompose.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: ${PROJECT_NAME}
 * file: ${FILE_NAME}
 * date: ${DATE}
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-17 22:23
 * @desc compose function
 **/
package com.xlab.service_java_infrastructure.java8chapter1;

import java.util.function.Function;

public class FunctionCompose {

    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.compose(g);
        int result = h.apply(1);
        System.out.println(result);
    }
}

