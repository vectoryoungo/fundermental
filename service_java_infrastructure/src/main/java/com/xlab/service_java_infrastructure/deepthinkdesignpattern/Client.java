/*
 * module: fundermental
 * file: Client.java
 * date: 4/7/19 9:44 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-07 09:43
 * @desc test of deepthinkpattern client
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern;

public class Client {

    public static void main(String[] args) {
        NewsPaper newsPaper = new NewsPaper();
        Reader reader = new Reader();
        reader.setName("Smith");
        Reader copy = new Reader();
        copy.setName("Larry");

        newsPaper.attach(reader);
        newsPaper.attach(copy);

        newsPaper.setContent("this is washington newspaper and liberty will be win all the time");

        newsPaper.detach(copy);
        newsPaper.setContent("update newspaper ");
    }
}

