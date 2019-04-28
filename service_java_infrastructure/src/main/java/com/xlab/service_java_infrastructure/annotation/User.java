/*
 * module: fundermental
 * file: User.java
 * date: 4/28/19 4:37 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-28 16:37
 * @desc user tester of annotation
 **/
package com.xlab.service_java_infrastructure.annotation;


@Table("user")
public class User {
    @Column("id")
    private int id;
    @Column("name")
    private String name;
    @Column("age")
    private int age;
    @Column("address")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

