/**
 * @create 2019-08-26 11:19
 * @desc response util
 **/
package com.xlab.service_java_infrastructure.bitcoinj.hd;

public class Response<T> {

    private T data;
    private Integer code;
    private String msg;

    public Response () {}

    public Response(T t,Integer code,String msg) {
        this.data = t;
        this.code = code;
        this.msg = msg;
    }

    public Response success(T t,String msg){
        return new Response(t,1,msg);
    }

    public Response fail(T t,String msg) {
        return new Response(t,-1,msg);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

