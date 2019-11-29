/*
 * module: fundermental
 * file: MyBerkeleyDBQueue.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: MyBerkeleyDBQueue.java
 * date: 1/25/19 2:54 PM
 * author: VectorJu
 * 复制测试阿里云栖社区的开源的实现
 */

/**
 * @create 2019-01-25 14:54
 * @desc MyBerkeleyDBQueue
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.math.BigInteger;

public class MyBerkeleyDBQueue {

    /*private MyBerkeleyDB database; //数据库
    private static final BigInteger BigIntegerIncrement = BigInteger.valueOf(1); //key值的递增值
    private BigInteger head; //队列头部
    private BigInteger tail; //队列尾部
    private BigInteger current; //用于遍历数据库的当前位置
    private static final String headString = "head";
    private static final String tailString = "tail";
    public MyBerkeleyDBQueue(){ database = new MyBerkeleyDB(); } //初始化数据库
    public void open(String dbName){
        database.setEnvironment(database.getPath(),database.getChacheSize());
        database.open(dbName);//打开数据库
        head = (BigInteger) database.get("head");
        tail = (BigInteger) database.get("tail");

        if(head == null||tail == null) {
            head = BigInteger.valueOf(0);
            tail = BigInteger.valueOf(-1);
            database.put(headString, head);
            database.put(tailString, tail);
        }
        current = BigInteger.valueOf(head.longValue());
    }
    //设置编码
    public void setCharset(String charset) { database.setCharset(charset); }
    //设置路径
    public void setPath(String path){ database.setPath(path); }
    //设置缓冲区大小
    public boolean setChacheSize(long size){ return database.setChacheSize(size); }
    //入队
    public void enQueue(Object value){
        if(value == null) return;
        tail = tail.add(MyBerkeleyDBQueue.BigIntegerIncrement);
        database.put(tailString, tail);
        database.put(tail, value); //入队，队尾加1
    }
    //出队
    public Object deQueue(){
        Object value = database.del(head);//获取队头元素并将其删除
        if(value != null){
            head = head.add(BigIntegerIncrement);
            database.put(headString, head);
        } return value;
    }
    //队头值
    public Object head(){ return head; }
    //队尾值
    public Object tail(){ return tail; }
    //关闭
    public void close() { this.database.close(); }
    //获取数据库存储数据的大小
    public long size() { return database.size()-2; }
    //得到当前的游标值
    public Object current(){ return database.get(current); }
    //得到第一个游标值
    public Object first(){
            current = BigInteger.valueOf(head.longValue());
            return current();
    }
    //得到第一个游标值
    public Object last(){
        current = BigInteger.valueOf(tail.longValue());
        return current();
    }
    //得到下一个游标值
    public Object next(){
        if(current.compareTo(tail)<0){
            current = current.add(BigIntegerIncrement);
            return current();
        } return null;
    }
    //得到上一个游标值
    public Object prev(){
        if(current.compareTo(head)>0) {
            current = current.divide(BigIntegerIncrement);
            return current();
        } return null;
    }*/
}

