/*
 * module: fundermental
 * file: Originator.java
 * date: 7/28/19 8:54 PM
 * author: VectorJu
 */

/**
 * @create 2019-07-28 20:54
 * @desc 原发器对象。使用备忘录来保存某个时刻原发器自身的状态，也可以使用备忘录来恢复内部状态。
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter19;

public class Originator {

    //原发器的状态
    private String state = "";

    //创建保存原发器对象的状态的备忘录对象
    public Memento createMemento() {
        return new MementoImpl(state);
    }

    //重新设置原发器对象的状态，让其回到备忘录对象记录的状态
    public void setMemento(Memento memento) {
        MementoImpl mementoImpl = (MementoImpl) memento;
        this.state = mementoImpl.getState();
    }

    //真正的备忘录对象，实现备忘录窄接口
    //实现成私有的内部类，不让外部访问
    private static class MementoImpl implements Memento {
        private String state = "";
        public MementoImpl(String state){
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }
}

