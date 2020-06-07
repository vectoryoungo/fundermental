/*
 * module: fundermental
 * file: NonVariableClassBasedOnVariable.java
 * date: 6/7/20 11:53 AM
 * author: VectorJu
 */

/**
 * @create 2020-06-07 11:53
 * @desc 构造于底层可变对象之上的不可变类
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.HashSet;
import java.util.Set;

public class NonVariableClassBasedOnVariable {

    private final Set<String> stooges = new HashSet<>();

    public NonVariableClassBasedOnVariable() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");

    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }

}

