/*
 * module: fundermental
 * file: InstantiateGenericType.java
 * date: 4/9/19 8:33 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 08:33
 * @desc InstantiateGenericType
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

import java.util.concurrent.Executors;

public class InstantiateGenericType {

    public static void main(String[] args) {
        ClassAsFactory<Employee> employeeClassAsFactory = new ClassAsFactory<Employee>(Employee.class);
        System.out.println(employeeClassAsFactory + " has been created ");
        try {
            ClassAsFactory<Integer> classAsFactory = new ClassAsFactory<>(Integer.class);
            System.out.println(classAsFactory + " has been created ");
        }catch (Exception e) {
            System.out.println(" create ClassAsFactory<Integer> failed some unexpected trouble has been occured!");
        }
    }
}

