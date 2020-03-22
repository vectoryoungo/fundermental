/**
 * @create 2020-03-18 18:49
 * @desc test config when springboot start
 **/
package com.xlab.service_java_infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-99)
public class VectorConfig {

    @Value("${vector.value}")
    private String vectorValue;

    public Object getVector() {

        Object bean = SpringUtil.getBean(VectorConfig.class);

        if (bean instanceof VectorConfig) {
            System.out.println("获取的Bean是VectorConfig");
            System.out.println(vectorValue);
        }

        return bean;
    }
}

