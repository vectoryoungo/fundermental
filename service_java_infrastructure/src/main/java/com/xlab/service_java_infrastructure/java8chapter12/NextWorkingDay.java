/*
 * module: fundermental
 * file: NextWorkingDay.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

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

import java.time.*;
import java.time.chrono.MinguoDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;
import java.util.Locale;
import java.util.TimeZone;

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

    //为时间点添加时区信息
    public void addZoneInfo() {
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println("zoneId " + zoneId);
        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zdt1 = date.atStartOfDay(zoneId);
        System.out.println("zdt1 " + zdt1);
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(zoneId);
        System.out.println("zdt2 " + zdt2);
        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(zoneId);
        System.out.println("zdt3 " + zdt3);
    }

    public void nonISOCalendaring() {
        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        MinguoDate minguoDate = MinguoDate.from(date);
        System.out.println(minguoDate);

    }

    public static void main(String[] args) {
        NextWorkingDay nextWorkingDay = new NextWorkingDay();
        System.out.println("adjust with localdate " + nextWorkingDay.adjustWithLocalDate(LocalDate.now()));
        System.out.println(" lambda localdate return " + nextWorkingDay.adjustWithLambda(LocalDate.now()));
        System.out.println(" formatted date is " + nextWorkingDay.createLocalDateWithSpecificFormat());
        System.out.println(" italian formatted is " + nextWorkingDay.createLocalDateTimeFormatter());
        System.out.println(" zone info ");
        nextWorkingDay.addZoneInfo();
        nextWorkingDay.nonISOCalendaring();
    }
}

