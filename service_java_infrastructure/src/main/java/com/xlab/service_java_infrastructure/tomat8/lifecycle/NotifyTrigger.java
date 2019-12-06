package com.xlab.service_java_infrastructure.tomat8.lifecycle;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotifyTrigger implements Lifecycle {

    private final List<LifecycleListener> lifecycleListeners = new CopyOnWriteArrayList<>();

    private boolean flag = true;

    public void setFlag(final boolean flag) {
        this.flag = flag;
    }

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
        System.out.println("NotifyTrigger");
        while (flag) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.now();
            String stringTime = dateTimeFormatter.format(localDateTime);
            System.out.println(stringTime);
            if (localDateTime.getHour() == 14 && localDateTime.getMinute() == 45 && localDateTime.getSecond() == 0) {
            }
        }

    }

    @Override
    public void start() throws LifecycleException {

    }

    @Override
    public void stop() throws LifecycleException {

    }

    @Override
    public void destroy() throws LifecycleException {

    }

    @Override
    public LifecycleState getState() {
        return null;
    }

    @Override
    public String getStateName() {
        return null;
    }

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String stringTime = dateTimeFormatter.format(localDateTime);
        System.out.println(stringTime);
    }
}
