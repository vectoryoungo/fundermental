package com.xlab.service_java_infrastructure.deepthinkdesignpattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> readers = new ArrayList<>();

    public void attach(Observer reader) {
        readers.add(reader);
    }

    public void detach(Observer reader) {
        readers.remove(reader);
    }

    protected void notifyObservers() {
        for (Observer observer:readers) {
            observer.update(this);
        }
    }
}
