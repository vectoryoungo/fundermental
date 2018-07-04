/*
 * module: fundermental
 * file: LocalDateSimulator.java
 * date: 18-7-4 上午8:22
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-07-04 08:22
 * @desc local date test lab
 **/
package com.xlab.service_java_infrastructure.java8chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class LocalDateSimulator {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2018,7,4);
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int day = localDate.getDayOfMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int lengthOfMonth = localDate.lengthOfMonth();
        boolean leapYear = localDate.isLeapYear();//闰年
        System.out.println("year is " + year);
        System.out.println("month is " + month);
        System.out.println("day is " + day);
        System.out.println("dayOfWeek is " + dayOfWeek);
        System.out.println("lengthOfMonth is " + lengthOfMonth);
        System.out.println("leapYear is " + leapYear);
        System.out.println("now is " + LocalDate.now());
    }
}

