/*
 * module: fundermental
 * file: ExcelImport.java
 * date: 5/15/19 3:14 PM
 * author: VectorJu
 */

/**
 * @create 2019-05-15 15:14
 * @desc test of import excel
 **/
package com.xlab.service_java_infrastructure.basic;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelImport {

    @RequestMapping(value = "/readExcel", method = RequestMethod.POST)
    public void readExcel(MultipartFile file){

        long t1 = System.currentTimeMillis();
        List<ProductInfo> list = ExcelUtils.readExcel("", ProductInfo.class, file);
        for (ProductInfo productInfo:list) {
            System.out.println(" product info is " + productInfo);
        }
        long t2 = System.currentTimeMillis();
        System.out.println(String.format("read over! cost:%sms", (t2 - t1)));
        list.forEach(
                b -> System.out.println(JSON.toJSONString(b))
        );
    }
}

