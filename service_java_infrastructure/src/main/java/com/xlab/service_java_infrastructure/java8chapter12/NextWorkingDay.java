/*
 * module: fundermental
 * file: NextWorkingDay.java
 * date: 18-7-5 上午8:38
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-07-05 08:38
 * @desc 实现一个定制的TemporalAdjuster
 **/
package com.xlab.service_java_infrastructure.java8chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;
import java.util.Locale;

public class NextWorkingDay implements TemporalAdjuster{


    @Override
    public Temporal adjustInto(Temporal temporal) {

        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

        int dayToAdd = 1;
        if (dayOfWeek == DayOfWeek.FRIDAY) {
            dayToAdd = 3;
        }else if (dayOfWeek == DayOfWeek.SATURDAY){
            dayToAdd = 2;
        }

        return temporal.plus(dayToAdd, ChronoUnit.DAYS);
    }

    public Temporal adjustWithLocalDate(LocalDate date) {
        date = date.with(temporal -> {DayOfWeek dayofWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int dayToAdd = 1;
        if (dayofWeek == DayOfWeek.FRIDAY) {
            dayToAdd = 3;
        }else if (dayofWeek == DayOfWeek.SATURDAY) {
            dayToAdd = 2;
        }
        return temporal.plus(dayToAdd,ChronoUnit.DAYS);});

        return date;
    }

    public LocalDate adjustWithLambda(LocalDate date) {
        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
                temporal-> {
                    DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
                    int dayToAdd = 1;
                    if (dayOfWeek == DayOfWeek.FRIDAY) {
                        dayToAdd = 3;
                    }else if (dayOfWeek == DayOfWeek.SATURDAY) {
                        dayToAdd = 2;
                    }
                    return temporal.plus(dayToAdd,ChronoUnit.DAYS);
                }
        );

        return date = date.with(nextWorkingDay);
    }

    //按照某个模式创建DateTimeFormatter
    public LocalDate createLocalDateWithSpecificFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.of(2018,7,5);
        String formattedDate = localDate.format(formatter);
        System.out.println("format " + formattedDate);
        LocalDate newLocalDate = LocalDate.parse(formattedDate,formatter);
        return newLocalDate;
    }
    //创建一个本地化的DateTimeFormatter
    public LocalDate createLocalDateTimeFormatter() {
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate localDate = LocalDate.of(2018,9,9);
        String formattedDate = localDate.format(italianFormatter);
        System.out.println("italian formatted is " + formattedDate);
        LocalDate newLocalDate = LocalDate.parse(formattedDate,italianFormatter);
        return newLocalDate;
    }

    //自定义解析，构建自己的格式器。比如区分大小写的解析，柔性解析，填充，以及在格式解析器中指定可选节。
    public void constructSelfDefineFormatter() {
        DateTimeFormatter italianFormatteer = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(".")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter();
    }

    public static void main(String[] args) {
        NextWorkingDay nextWorkingDay = new NextWorkingDay();
        System.out.println("adjust with localdate " + nextWorkingDay.adjustWithLocalDate(LocalDate.now()));
        System.out.println(" lambda localdate return " + nextWorkingDay.adjustWithLambda(LocalDate.now()));
        System.out.println(" formatted date is " + nextWorkingDay.createLocalDateWithSpecificFormat());
        System.out.println(" italian formatted is " + nextWorkingDay.createLocalDateTimeFormatter());
    }
}

