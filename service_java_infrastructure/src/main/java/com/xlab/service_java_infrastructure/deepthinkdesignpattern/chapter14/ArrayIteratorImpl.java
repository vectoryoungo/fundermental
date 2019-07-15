package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter14;

public class ArrayIteratorImpl implements Iterator {

    private SalaryManagerRefactor salaryManager = null;

    private int index = -1;

    public ArrayIteratorImpl(SalaryManagerRefactor salaryManager) {
        this.salaryManager = salaryManager;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {

        if (index<this.salaryManager.size()) {
            index = index + 1;
        }
    }

    @Override
    public boolean isDone() {

        if (index == this.salaryManager.size()) return true;
        return false;
    }

    @Override
    public Object currentItem() {

        return this.salaryManager.get(index);
    }
}
