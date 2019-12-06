package com.xlab.service_java_infrastructure.tomat8.lifecycle;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * LifecycleSupport has been removed from tomcat8
 */

public class VectorLabLifecycle implements Lifecycle {

    private final List<LifecycleListener> lifecycleListeners = new CopyOnWriteArrayList<>();

    @Override
    public void addLifecycleListener(LifecycleListener listener) {
        lifecycleListeners.add(listener);
    }

    @Override
    public LifecycleListener[] findLifecycleListeners() {
        return lifecycleListeners.toArray(new LifecycleListener[0]);
    }

    @Override
    public void removeLifecycleListener(LifecycleListener listener) {
        lifecycleListeners.remove(listener);
    }

    @Override
    public void init() throws LifecycleException {
        System.out.println(" VectorLab Lifecycle initializing ......");
    }

    @Override
    public void start() throws LifecycleException {
        System.out.println(" VectorLab Lifecycle start......");
    }

    @Override
    public void stop() throws LifecycleException {
        System.out.println(" VectorLab Lifecycle stop......");
    }

    @Override
    public void destroy() throws LifecycleException {
        System.out.println(" VectorLab destroy ");
    }

    @Override
    public LifecycleState getState() {
        return null;
    }

    @Override
    public String getStateName() {
        return null;
    }
}
