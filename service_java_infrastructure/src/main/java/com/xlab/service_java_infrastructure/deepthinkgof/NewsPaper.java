package com.xlab.service_java_infrastructure.deepthinkgof;

import java.util.Observable;

public class NewsPaper extends Subject {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyObservers();
    }
}
