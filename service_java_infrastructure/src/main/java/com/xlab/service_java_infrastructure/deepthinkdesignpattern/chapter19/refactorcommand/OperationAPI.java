package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter19.refactorcommand;

public interface OperationAPI {

    public int getResult();
    public void add(int num);
    public void substract(int num);
    public Memento createMemento();
    public void setMemento(Memento memento);
}
