package com.xlab.service_java_infrastructure.deepthinkdesignpattern.refactor;

import java.util.Observable;
import java.util.Observer;

public class Reader implements Observer {

    private String name;

    @Override
    public void update(Observable o, Object arg) {
        //this is push
        System.out.println(name + " has received newspaper content is " + arg);

        //this is pull
        System.out.println(name+" has received newspaper content is " + ((NewsPaper)o).getContent());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
