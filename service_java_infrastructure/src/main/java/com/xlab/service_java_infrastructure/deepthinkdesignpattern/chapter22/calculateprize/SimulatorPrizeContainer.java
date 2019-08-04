/*
 * module: fundermental
 * file: SimulatorPrizeContainer.java
 * date: 8/4/19 5:19 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 17:19
 * @desc hold simulate prize
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter22.calculateprize;

import java.util.HashMap;
import java.util.Map;

public class SimulatorPrizeContainer {

    private SimulatorPrizeContainer(){}

    public static Map<String,Double> prizeHolder = new HashMap<>(16);

    static {
        prizeHolder.put("Tom",10000.00);
        prizeHolder.put("John",20000.00);
        prizeHolder.put("Triumph",500000000.00);
    }
}

