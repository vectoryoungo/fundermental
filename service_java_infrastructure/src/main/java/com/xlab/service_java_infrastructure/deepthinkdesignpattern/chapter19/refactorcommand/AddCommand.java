package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter19.refactorcommand;

public class AddCommand extends AbstractCommand {

    private int operateNumber;

    public AddCommand(int operateNumber) {
        this.operateNumber = operateNumber;
    }

    @Override
    public void execute() {
        this.operationAPI.add(operateNumber);
    }
}
