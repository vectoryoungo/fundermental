package com.xdlx.service.java.nosql;

import com.xdlx.service.java.nosql.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class NosqlApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(NosqlApplication.class, args);
        SpringContextUtil springContextUtil = new SpringContextUtil();
        springContextUtil.setApplicationContext(applicationContext);
    }

}
