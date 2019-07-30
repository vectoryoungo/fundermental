package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter20;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂，主要用来创建并管理共享的享元对象，并对外提供访问共享享元的接口
 */
public class FlyweightFactory {

    private Map<String,Flyweight> flyweightMap = new HashMap<>(16);

    public Flyweight getFlyweight(String key) {

        Flyweight flyweight = flyweightMap.get(key);

        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(key);
            flyweightMap.put(key,flyweight);
            return flyweight;
        }

        return flyweight;
    }
}
