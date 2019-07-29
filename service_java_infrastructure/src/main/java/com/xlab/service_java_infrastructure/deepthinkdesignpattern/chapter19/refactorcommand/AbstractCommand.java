package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter19.refactorcommand;

public abstract class AbstractCommand implements Command {

    public abstract void execute();

    protected OperationAPI operationAPI = null;

    public void setOperation(OperationAPI operation) {
        operationAPI = operation;
    }

    @Override
    public void undo(Memento memento) {
        this.operationAPI.setMemento(memento);
    }

    @Override
    public void redo(Memento memento) {
        this.operationAPI.setMemento(memento);
    }

    @Override
    public Memento createMemento() {
        return this.operationAPI.createMemento();
    }
}
