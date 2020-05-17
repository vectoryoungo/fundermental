/*
 * module: fundermental
 * file: DateUtilLab.java
 * date: 5/1/20 10:28 AM
 * author: VectorJu
 */

/**
 * @create 2020-05-01 10:28
 * @desc use case of date
 **/
package com.xlab.service_java_infrastructure.date;

import sun.net.www.content.text.Generic;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtilLab {

    public static int differentDays(Date first,Date second){

        if (first == null || second == null) {
            throw new RuntimeException("Date should not be null!!!");
        }
        LocalDate firstLocalDate = date2LocalDate(first);
        LocalDate secondLocalDate = date2LocalDate(second);
        int inteval = (int) firstLocalDate.until(secondLocalDate, ChronoUnit.DAYS);

        return inteval;
    }

    public static long differentDaysWithLocalDate(LocalDate first,LocalDate second) {
        return first.until(second,ChronoUnit.DAYS);
    }

    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        ZoneId shanghaiZone = ZoneId.of("Asia/Shanghai");
        System.out.println(shanghaiZone.getId());
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        LocalDate shanghaiDate = instant.atZone(shanghaiZone).toLocalDate();
        System.out.println(shanghaiDate);
        return localDate;
    }

    public static LocalDate formatDate(String strDate,String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(strDate,dateTimeFormatter);

    }

    public static void main(String[] args) {

        LocalDate first = formatDate("2020-01-01","yyyy-MM-dd");
        LocalDate second = formatDate("2019-12-25","yyyy-MM-dd");
        System.out.println(differentDaysWithLocalDate(first,second));
    }
}

