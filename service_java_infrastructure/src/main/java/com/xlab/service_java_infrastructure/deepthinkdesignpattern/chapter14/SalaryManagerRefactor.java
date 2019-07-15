package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter14;

public class SalaryManagerRefactor extends Aggregate {
    private PayModel[] payModels = null;
    public PayModel[] getPays() {
        return payModels;
    }

    public void calcSalary() {
        PayModel payModel = new PayModel();
        payModel.setPay(2200);
        payModel.setUserName("testerIII");
        PayModel payModel1 = new PayModel();
        payModel1.setUserName("testerV");
        payModel1.setPay(3600);
        payModels = new PayModel[2];
        payModels[0] = payModel;
        payModels[1] = payModel1;
    }

    @Override
    public Iterator createIterator() {
        return new ArrayIteratorImpl(this);
    }

    public Object get(int index) {
        Object object = null;
        if (index<payModels.length) {
            object = payModels[index];
        }

        return object;
    }

    public int size() {
        return this.payModels.length;
    }
}
