package com.xlab.service_java_infrastructure.deepthinkgof;

public class Reader implements Observer {

    private String name;

    @Override
    public void update(Subject subject) {
        System.out.println(name + " has received newspaper and content is " + ((NewsPaper)subject).getContent());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
