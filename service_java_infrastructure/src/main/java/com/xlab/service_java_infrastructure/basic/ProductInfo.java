/*
 * module: fundermental
 * file: ProductNo.java
 * date: 5/15/19 5:50 PM
 * author: VectorJu
 */

/**
 * @create 2019-05-15 17:50
 * @desc ProductInfo
 **/
package com.xlab.service_java_infrastructure.basic;

public class ProductInfo {

    @ExcelColumn(value = "商品编号", col = 1)
    private String productNo;

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
}

