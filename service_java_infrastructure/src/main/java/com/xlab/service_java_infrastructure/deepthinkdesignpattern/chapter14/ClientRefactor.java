package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter14;

import com.xlab.service_java_infrastructure.deepthinkdesignpattern.Observer;

public class ClientRefactor {

    public static void main(String[] args) {

        PayManagerRefactor payManager = new PayManagerRefactor();
        payManager.calcPay();
        System.out.println("company salary list");
        iterate(payManager.createIterator());

        SalaryManagerRefactor salaryManager = new SalaryManagerRefactor();
        salaryManager.calcSalary();
        System.out.println("new buy company salary list");
        iterate(salaryManager.createIterator());

    }

    private static void iterate(Iterator iterator) {
        iterator.first();
        while (!iterator.isDone()) {
            Object object = iterator.currentItem();
            System.out.println(" obj is " + object);
            iterator.next();
        }
    }
}

