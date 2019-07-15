package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter14;

public interface Iterator {
    public void first();
    public void next();
    public boolean isDone();
    public Object currentItem();
}
