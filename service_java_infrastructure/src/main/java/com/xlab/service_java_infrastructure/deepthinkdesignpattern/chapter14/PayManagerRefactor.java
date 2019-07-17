package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter14;

import java.util.ArrayList;
import java.util.List;

public class PayManagerRefactor extends Aggregate {

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


    @Override
    public Iterator createIterator() {
        return new CollectionIteratorImpl(this);
    }

    public Object get(int index) {
        Object object = null;
        if (index<this.list.size()) {
            object = this.list.get(index);
        }

        return object;
    }

    public int size() {
        return this.list.size();
    }
}
