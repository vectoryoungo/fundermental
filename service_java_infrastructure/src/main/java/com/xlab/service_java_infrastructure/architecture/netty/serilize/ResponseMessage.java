/*
 * module: fundermental
 * file: ResponseMessage.java
 * date: 6/28/19 11:08 AM
 * author: VectorJu
 */

/**
 * @create 2019-06-28 11:08
 * @desc serializable response message
 **/
package com.xlab.service_java_infrastructure.architecture.netty.serilize;

import java.io.Serializable;

public class ResponseMessage implements Serializable{

    private Long id;
    private String content;


    public ResponseMessage() {
    }

    public ResponseMessage(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

