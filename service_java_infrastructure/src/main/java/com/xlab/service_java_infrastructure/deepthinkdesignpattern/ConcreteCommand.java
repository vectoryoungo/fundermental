package com.xlab.service_java_infrastructure.deepthinkdesignpattern;

public class ConcreteCommand implements Command {

    /**
     * hold specific receiver
     */
    private Receiver receiver = null;

    /**
     * command could have it's own state
     */
    private String state;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //usually call receiver method to do really function
        receiver.action();
    }
}
