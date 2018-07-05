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
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

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
}

