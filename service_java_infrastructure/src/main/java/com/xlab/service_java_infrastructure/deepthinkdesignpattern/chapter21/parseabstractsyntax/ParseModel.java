/*
 * module: fundermental
 * file: ParseModel.java
 * date: 8/4/19 10:39 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 10:38
 * @desc 封装解析出来的元素对应的属性
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parseabstractsyntax;

public class ParseModel {

    private boolean singleValue;
    private boolean propertyValue;
    private boolean end;

    public boolean isSingleValue() {
        return singleValue;
    }

    public void setSingleValue(boolean singleValue) {
        this.singleValue = singleValue;
    }

    public boolean isPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(boolean propertyValue) {
        this.propertyValue = propertyValue;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}

