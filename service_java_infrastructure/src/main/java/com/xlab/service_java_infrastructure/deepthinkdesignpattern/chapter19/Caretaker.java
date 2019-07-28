/*
 * module: fundermental
 * file: Caretaker.java
 * date: 7/28/19 9:02 PM
 * author: VectorJu
 */

/**
 * @create 2019-07-28 21:02
 * @desc 备忘录管理者，或者称为备忘录负责人。主要负责保存备忘录对象，但是不能对备忘录对象的内容进行操作或检查。
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter19;

public class Caretaker {

    //记录被保存的备忘录对象
    private Memento memento = null;

    public void saveMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento retriveMemento() {
        return this.memento;
    }
}

