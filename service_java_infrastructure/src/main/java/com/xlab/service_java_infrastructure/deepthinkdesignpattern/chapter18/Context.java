package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter18;

public class Context {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    //customer need do
    public void request(String parameter) {
        state.handle(parameter);
    }
}
