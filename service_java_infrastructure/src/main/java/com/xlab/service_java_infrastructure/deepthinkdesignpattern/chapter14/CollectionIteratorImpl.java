package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter14;

public class CollectionIteratorImpl implements Iterator {

    private PayManagerRefactor payManager = null;

    private int index = -1;

    public CollectionIteratorImpl(PayManagerRefactor payManager) {
        this.payManager = payManager;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        if (index < this.payManager.size()) {
            index = index + 1;
        }
    }

    @Override
    public boolean isDone() {

        if (index == this.payManager.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Object currentItem() {
        return this.payManager.get(index);
    }
}
