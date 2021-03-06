/*
 * module: fundermental
 * file: EnumTest.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/**
 * @author juhongtao
 * @create 2018-11-20 18:01
 * @desc test
 **/
package com.xlab.service_java_infrastructure.refactor;

public enum  EnumTest {
    BUY(1,"buy"),
    SELL(2,"sell");

    private Integer code;
    private String description;

    EnumTest(Integer code,String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static EnumTest getByCode(int code) {
        for (EnumTest enumTest:values()) {
            if (enumTest.code == code) {
                return enumTest;
            }
        }
        return null;
    }
}

