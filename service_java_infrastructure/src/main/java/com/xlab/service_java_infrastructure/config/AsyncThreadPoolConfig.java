/**
 * @create 2020-06-14 15:15
 * @desc test async config
 **/
package com.xlab.service_java_infrastructure.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class AsyncThreadPoolConfig {
    private final int CORE_SIZE = Runtime.getRuntime().availableProcessors();
    private final int MAX_SIZE = CORE_SIZE * 2;
    private final int QUEUE_CAPACITY = 50;
    private final int KEEP_ALIVE_SECOND = 10;
    private final String PREFIX = "vector-";

    @Bean("vectorThreadPool")
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_SIZE);
        executor.setMaxPoolSize(MAX_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.setThreadNamePrefix(PREFIX);
        executor.setKeepAliveSeconds(KEEP_ALIVE_SECOND);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        System.out.println("core size "+ CORE_SIZE);
        System.out.println("max size " + MAX_SIZE);
        System.out.println("queue capacity" + QUEUE_CAPACITY);
        return executor;
    }

}

