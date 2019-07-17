package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter14;

import java.util.ArrayList;
import java.util.List;

public class PayManager {

    private List list = new ArrayList();

    public List getPayList() {
        return list;
    }

    public void calcPay() {
        PayModel payModel = new PayModel();
        payModel.setPay(3800);
        payModel.setUserName("testerI");
        PayModel payModel1 = new PayModel();
        payModel1.setUserName("testerII");
        payModel1.setPay(5800);
        list.add(payModel);
        list.add(payModel1);
    }
}
