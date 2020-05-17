package com.sdlx.sh.vector.multidb.xdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = {"com.sdlx.sh.vector.multidb.xdb"})
@SpringBootApplication
@EnableTransactionManagement
public class XdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(XdbApplication.class, args);
	}

}
