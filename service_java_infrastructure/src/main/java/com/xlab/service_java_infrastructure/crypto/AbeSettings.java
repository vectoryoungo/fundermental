/*
 * module: fundermental
 * file: AbeSettings.java
 * date: 3/14/19 11:19 AM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

package com.xlab.service_java_infrastructure.crypto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AbeSettings {
    public final static DateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static String STRINGS_LOCALE = "US-ASCII";
    public final static String ELEMENT_HASHING_ALGORITHM = "SHA-1";
    public final static String curveParams = "type a\n" + "q 87807107996633125224377819847540498158068831994142082"
            + "1102865339926647563088022295707862517942266222142315585"
            + "8769582317459277713367317481324925129998224791\n"
            + "h 12016012264891146079388821366740534204802954401251311"
            + "822919615131047207289359704531102844802183906537786776\n"
            + "r 730750818665451621361119245571504901405976559617\n" + "exp2 159\n" + "exp1 107\n"
            + "sign1 1\n" + "sign0 1\n";

    public static String getCurrentTime() {
        return AbeSettings.defaultDateFormat.format(Calendar.getInstance().getTime());
    }
}
