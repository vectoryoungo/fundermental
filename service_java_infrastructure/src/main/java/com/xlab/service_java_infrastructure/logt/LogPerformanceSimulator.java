/*
 * module: fundermental
 * file: LogPerformaceSimulator.java
 * date: 7/12/19 10:05 AM
 * author: VectorJu
 */

/**
 * @create 2019-07-12 10:05
 * @desc test improve performance of logback param write
 **/
package com.xlab.service_java_infrastructure.logt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogPerformanceSimulator {

    private static final Logger logger = LoggerFactory.getLogger(LogPerformanceSimulator.class);


    private static void showPerformaceLog(String key,String content) {
        logger.debug("Processing trade with key:[{}] and content : [{}] ", key, content);
    }

    public static void main(String[] args) {
        showPerformaceLog("vector" ,"update user balance");
    }
}

