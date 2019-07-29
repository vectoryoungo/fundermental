package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter19.refactorcommand;

public class Client {

    public static void main(String[] args) {
        //1.组装命令和接收者
        //创建接收者
        OperationAPI operationAPI = new Operation();
        //创建命令
        AddCommand addCommand = new AddCommand(10);
        SubstractCommand substractCommand = new SubstractCommand(5);

        //组装命令和接收者
        addCommand.setOperation(operationAPI);
        substractCommand.setOperation(operationAPI);

        //2.把命令设置到持有者，就是计算器中
        Calculator calculator = new Calculator();
        calculator.setAddCommand(addCommand);
        calculator.setSubstractCommand(substractCommand);

        //3.模拟按下按钮
        calculator.addPressed();
        System.out.println("after one add operate result is : " + operationAPI.getResult());
        calculator.substractPressed();
        System.out.println("after one substract operate result is " + operationAPI.getResult());

        //测试撤销
        calculator.undoPressed();
        System.out.println("after undo result is " + operationAPI.getResult());
        calculator.undoPressed();
        System.out.println("another undo result is " + operationAPI.getResult());

        //测试恢复
        calculator.redoPressed();
        System.out.println("after redo result is " + operationAPI.getResult());
        calculator.redoPressed();
        System.out.println("another redo result is " + operationAPI.getResult());
    }
}
