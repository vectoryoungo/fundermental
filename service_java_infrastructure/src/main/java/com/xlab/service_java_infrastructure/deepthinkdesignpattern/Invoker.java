package com.xlab.service_java_infrastructure.deepthinkdesignpattern;

public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void runCommand() {
        command.execute();
    }
}
