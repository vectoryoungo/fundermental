package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter14;

import java.util.Collection;
import java.util.Iterator;

public class Client {

    public static void main(String[] args) {
        PayManager payManager = new PayManager();
        payManager.calcPay();
        Collection payList = payManager.getPayList();
        Iterator it = payList.iterator();
        System.out.println("company salary list ");
        while (it.hasNext()) {
            PayModel payModel = (PayModel)it.next();
            System.out.println(payModel);
        }

        SalaryManager salaryManager = new SalaryManager();
        salaryManager.calcSalary();
        PayModel[] payModels = salaryManager.getPays();
        System.out.println("new buy company salary list ");
        for (int i=0;i<payModels.length;i++) {
            System.out.println(payModels[i]);
        }
    }
}
