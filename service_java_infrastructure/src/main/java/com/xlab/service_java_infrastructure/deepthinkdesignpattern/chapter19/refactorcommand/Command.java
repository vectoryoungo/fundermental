package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter19.refactorcommand;

public interface Command {

    public void execute();
    public void undo(Memento memento);
    public void redo(Memento memento);
    public Memento createMemento();
}
