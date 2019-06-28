/*
 * module: fundermental
 * file: RequestMessage.java
 * date: 6/28/19 10:23 AM
 * author: VectorJu
 */

/**
 * @create 2019-06-28 10:23
 * @desc user define message object
 **/
package com.xlab.service_java_infrastructure.architecture.netty.serilize;

import java.io.Serializable;
import java.util.Arrays;

public class RequestMessage implements Serializable{

    private Long id;
    private String message;
    private byte[] attachment;

    public RequestMessage() {
        super();
    }

    public RequestMessage(Long id, String message, byte[] attachment) {
        this.id = id;
        this.message = message;
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "RequestMessage{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", attachment=" + Arrays.toString(attachment) +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }
}

