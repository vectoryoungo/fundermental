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

import java.time.*;
import java.time.temporal.ChronoField;

public class LocalDateSimulator {

    private static final LocalDate localDate = LocalDate.of(2018,7,4);

    public static void main(String[] args) {
        showInstant();
    }

    public static void showLocalDate() {
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

    //使用TemporalField读取LocalDate的值
    public static void getLocalDateWithTemporalField() {

        int year = localDate.get(ChronoField.YEAR);
        int month = localDate.get(ChronoField.MONTH_OF_YEAR);
        int day = localDate.get(ChronoField.DAY_OF_MONTH);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
    }

    public static void createLocalTimeAndShow() {
        LocalTime localTime = LocalTime.of(8,42,9);
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int seconds = localTime.getSecond();
        System.out.println(" hour " + hour);
        System.out.println(" minute " + minute);
        System.out.println(" seconds " + seconds);
    }

    public static void parseLocalDateAndTime() {
        LocalDate localDate = LocalDate.parse("2018-07-04");
        LocalTime localTime = LocalTime.parse("08:45:46");
        System.out.println("localDate " + localDate);
        System.out.println("localTime " + localTime);
    }

    //合并日期和时间 LocalDateTime combined LocalDate with LocalTime
    //直接创建LocalDateTime对象，或者通过合并日期和时间的方式创建
    public static void combineDateAndTime() {
        LocalDate localDate = LocalDate.parse("2018-07-04");
        LocalTime localTime = LocalTime.parse("08:45:46");
        // 2014-03-18T13:45:20
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(localDate, localTime);
        LocalDateTime dt3 = localDate.atTime(13, 45, 20);
        LocalDateTime dt4 = localDate.atTime(localTime);
        LocalDateTime dt5 = localTime.atDate(localDate);
        System.out.println("dt1 " + dt1);
        System.out.println("dt2 " + dt2);
        System.out.println("dt3 " + dt3);
        System.out.println("dt4 " + dt4);
        System.out.println("dt5 " + dt5);
        //get localDate from LocalDateTime
        //get localTime from LocalDateTime
        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
        System.out.println(" localDate get from LocalDateTime is " + date1);
        System.out.println(" localTime get from LocalDateTime is " + time1);
    }

    //机器的日期和时间格式
    //我们想要特别强调一
    //点，Instant的设计初衷是为了便于机器使用。它包含的是由秒及纳秒所构成的数字。所以，它
    //无法处理那些我们非常容易理解的时间单位。
    public static void showInstant() {
        Instant one = Instant.ofEpochSecond(3);
        Instant two = Instant.ofEpochSecond(3, 0);
        Instant three = Instant.ofEpochSecond(2, 1_000_000_000);
        Instant four = Instant.ofEpochSecond(4, -1_000_000_000);
        System.out.println(" instant is " + one);
        System.out.println(" instant two is " + two);
        System.out.println(" instant three is " + three);
        System.out.println(" instant four is " + four);
        int day = Instant.now().get(ChronoField.DAY_OF_MONTH);
        System.out.println("day is "+ day);
    }

}

