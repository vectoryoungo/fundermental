package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter19.refactorcommand;

public class SubstractCommand extends AbstractCommand {

    private int operateNumber;

    public SubstractCommand(int operateNumber) {
        this.operateNumber = operateNumber;
    }


    @Override
    public void execute() {
        this.operationAPI.substract(operateNumber);
    }
}
