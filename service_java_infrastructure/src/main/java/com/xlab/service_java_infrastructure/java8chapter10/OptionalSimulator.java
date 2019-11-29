/*
 * module: fundermental
 * file: OptionalSimulator.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: OptionalSimulator.java
 * date: 18-6-30 上午10:48
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-30 10:48
 * @desc simulate option
 **/
package com.xlab.service_java_infrastructure.java8chapter10;

import java.util.Optional;

public class OptionalSimulator {

    public static void main(String[] args) {
        Car car = null;
        Optional<Car> optionalCar = Optional.of(car);// this will cause NullPointerException
    }
}

