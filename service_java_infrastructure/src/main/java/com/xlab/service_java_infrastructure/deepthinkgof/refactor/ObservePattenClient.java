package com.xlab.service_java_infrastructure.deepthinkgof.refactor;

public class ObservePattenClient {

    public static void main(String[] args) {
        NewsPaper newsPaper = new NewsPaper();
        Reader reader = new Reader();
        reader.setName("Harry");
        Reader follow = new Reader();
        follow.setName("Jerry");

        Reader secondFollow = new Reader();
        secondFollow.setName("Tom");

        newsPaper.addObserver(reader);
        newsPaper.addObserver(follow);
        newsPaper.addObserver(secondFollow);

        newsPaper.setContent("The Washington Post Breaking News China CCP will break down in two years");
    }
}
