package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter19.refactorcommand;

public class Operation implements OperationAPI {

    private int result;

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void add(int num) {
        result += num;
    }

    @Override
    public void substract(int num) {
        result -= num;
    }

    @Override
    public Memento createMemento() {

        MementoImpl memento = new MementoImpl(result);

        return memento;
    }

    @Override
    public void setMemento(Memento memento) {
        MementoImpl mementoImpl = (MementoImpl) memento;
        this.result = mementoImpl.getResult();
    }

    private static class MementoImpl implements Memento {
        private int result = 0;
        public MementoImpl(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }
    }
}
