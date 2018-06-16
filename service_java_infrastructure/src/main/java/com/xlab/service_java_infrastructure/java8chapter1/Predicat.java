/*
 * module: ${PROJECT_NAME}
 * file: ${FILE_NAME}
 * date: ${DATE}
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-16 18:14
 * @desc predict
 **/
package com.xlab.service_java_infrastructure.java8chapter1;

public interface Predicat<T> {
    boolean test(T t);
}

