package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter19.refactorcommand;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    //命令的操作历史记录，在撤销时用
    private List<Command> undoCmds = new ArrayList<>();
    //命令撤销的历史记录，在恢复时用
    private List<Command> redoCmds = new ArrayList<>();

    //命令操作对应的备忘录对象的历史记录，在撤销时用数组有两个元素，第一个是命令执行前的状态，第二个是命令执行后的状态
    private List<Memento[]> undoMementos = new ArrayList<>();
    //被撤销命令对应的备忘录对象的历史记录，在恢复时用，数组有两个元素，第一个是命令执行前的状态，第二个是命令执行后的状态
    private List<Memento[]> redoMementos = new ArrayList<>();

    private Command addCommand = null;
    private Command substractCommand = null;

    public void setAddCommand(Command addCommand) {
        this.addCommand = addCommand;
    }

    public void setSubstractCommand(Command substractCommand) {
        this.substractCommand = substractCommand;
    }

    public void addPressed() {

        //获取对应的备忘录对象，并保存在相应的历史记录中
        Memento memento = this.addCommand.createMemento();
        //执行命令
        this.addCommand.execute();
        //把操作记录到历史记录中
        undoCmds.add(this.addCommand);

        //获取执行命令后的备忘录对象
        Memento memento1 = this.addCommand.createMemento();
        //设置到撤销的历史记录中
        this.undoMementos.add(new Memento[]{memento,memento1});
    }

    public void substractPressed() {
        //获取对应的备忘录对象，并保存在相应的历史记录中
        Memento memento = this.substractCommand.createMemento();
        //执行命令
        this.substractCommand.execute();
        //把操作记录到历史记录中
        undoCmds.add(this.substractCommand);
        //获取执行命令后的备忘录对象
        Memento memento1 = this.substractCommand.createMemento();
        //设置到撤销的历史记录中
        this.undoMementos.add(new Memento[]{memento,memento1});
    }

    public void undoPressed() {
        if (undoCmds.size() > 0) {
            Command command = undoCmds.get(undoCmds.size() -1);
            Memento[] mementos = undoMementos.get(undoCmds.size() -1);
            command.undo(mementos[0]);

            //如果还有恢复的功能，就把这个命令记录到恢复的历史记录中
            redoCmds.add(command);
            //把相应的备忘录对象也添加过去
            redoMementos.add(mementos);
            //然后把最后一个命令删除
            undoCmds.remove(command);
            //把相应的备忘录对象叶删除
            undoMementos.remove(mementos);
        }else {
            System.out.println("sorry , no undo command...");
        }
    }

    public void redoPressed() {

        if (redoCmds.size() > 0 ) {
            //取最后一个命令来重做
            Command command = redoCmds.get(redoCmds.size() -1);
            Memento[] mementos = redoMementos.get(redoCmds.size() - 1);

            //重做
            command.redo(mementos[1]);

            //把这个命令记录到可撤销的历史记录中
            undoCmds.add(command);
            //把相应的备忘录对象也添加过去
            undoMementos.add(mementos);
            //然后把最后一个命令删除
            redoCmds.remove(command);
            //把相应的备忘录对象也删除
            redoMementos.remove(mementos);
        }else {
            System.out.println("sorry , no redo command...");
        }

    }
}
