/*
 * module: fundermental
 * file: TradingViewSimulator.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: TradingViewSimulator.java
 * date: 1/2/19 11:22 AM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2019-01-02 11:22
 * @desc tradingview
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TradingViewSimulator {

//    private static String tvTableName = "dc_tv_fnl_eth";
    private static String tdTableName = "dc_td_fnl_eth";

    public static void main(String[] args) throws Exception{

        showMSG(null);

        /*BigDecimal bigDecimal = new BigDecimal("12.23589");
        BigDecimal result = bigDecimal.setScale(2, RoundingMode.FLOOR);
        System.out.println(result);
        BigDecimal bigDecimal1 = new BigDecimal("2200");
        System.out.println(bigDecimal1.setScale(2,RoundingMode.FLOOR));*/

        //genTvData("dc_tv_fnl_eth");
        /*Timestamp timestamp = Timestamp.valueOf("2019-01-01 10:17:40");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        LocalDateTime begin = timestamp.toLocalDateTime().withSecond(0);
        //LocalTime history = LocalTime.parse(time.toString(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime end = begin.plusSeconds(60);
        System.out.println(begin);
        System.out.println(end);
        System.out.println(localTime);
        System.out.println(localTime.withSecond(0));*/
        //System.out.println(history);
    }

    public static void genTvData(String strTickerName) {
        Timestamp timeStampLastTime = null;
        System.out.println("timeStampLastTime: " + timeStampLastTime);

        if (timeStampLastTime == null) {
            System.out.println("no data in tvTable: " + "dc_tv_fnl_eth");
            timeStampLastTime = getEarliestTimestamp(tdTableName); //最早历史交易时间戳
            if (timeStampLastTime == null) {
                try {
                    Thread.sleep(10000);
                    System.out.println(" thread " + Thread.currentThread().getName());
                    System.out.println(" parameter " + strTickerName);
                    System.out.println(" ************* ");
                    genTvData(strTickerName);
                    System.out.println(" over ");
                } catch (InterruptedException e) {
                    System.out.println(" interrupted ");
                    e.printStackTrace();
                }
            }
        }

    }

    public static Timestamp getTVLastDate(String tvTableName) {
        System.out.println(" method getTVLastDate " + tvTableName);
        return null;
    }

    public static Timestamp getEarliestTimestamp(String tvTableName) {
        System.out.println(" method getEarliestTimestamp " + tvTableName);
        return null;
    }

    public static void showMSG(String tdTableName) {

        try {
            if (tdTableName == null || "".equals(tdTableName)) {
                throw new Exception("error");
            }
            System.out.println("end in try ");
            return;

        }catch (Exception e) {
            System.out.println(" null " + e);
        }

        System.out.println("end out try ");
        return;
    }
}

