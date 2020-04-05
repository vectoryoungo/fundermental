/*
 * module: fundermental
 * file: WebSocketConfig.java
 * date: 4/5/20 5:21 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-05 17:21
 * @desc wesocket configuration
 **/
package com.sd.lx.vector.ws.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}

