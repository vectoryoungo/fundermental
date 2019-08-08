/*
 * module: fundermental
 * file: PersonalCustomer.java
 * date: 8/8/19 3:00 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 15:00
 * @desc personal customer
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.cutomermanagement;

public class PersonalCustomer extends Customer{

    private String mobile;
    private int age;
    private String name;

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPersonalCustomer(this);
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

