package com.xlab.service_java_infrastructure.deepthinkdesignpattern;

public class CreateCommandAndAssembleReceiver {

    public void assemble() {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
    }
}
