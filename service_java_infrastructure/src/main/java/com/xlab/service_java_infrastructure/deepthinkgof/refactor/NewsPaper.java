package com.xlab.service_java_infrastructure.deepthinkgof.refactor;

import java.util.Observable;

public class NewsPaper extends Observable {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.setChanged();
        //主动通知，这里用的是推的方式
        this.notifyObservers(this.content);

        //如果用拉的方式，这么调用
        //this.notifyObservers();
    }
}
