/*
 * module: fundermental
 * file: DogWang.java
 * date: 4/7/19 10:12 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-07 10:12
 * @desc dog wang
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.refactor;

public class DogWang {

    private String name;
    private String color;


    public String yell() {
        return "Wang Wang ";
    }

    public String run() {
        return "Dog Wang running";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {

        return " Dog " + name + " with "  + color + " color";
    }

}

