/*
 * module: fundermental
 * file: ObservableSet.java
 * date: 18-8-26 下午4:30
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-08-26 16:30
 * @desc broken concurrent test
 **/
package com.xlab.service_java_infrastructure.effective8;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObservableSet<E> extends ForwardingSet<E> {

    public ObservableSet(Set<E> set) { super(set); }

    private final List<SetObserver<E>> observers
            = new ArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        synchronized(observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized(observers) {
            return observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element) {
        synchronized(observers) {
            for (SetObserver<E> observer : observers)
                observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c)
            result |= add(element); // Calls notifyElementAdded
        return result;
    }

    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        /*set.addObserver((s,e) -> System.out.println(e));
        for(int i = 0;i < 100;i++) {
            set.add(i);
        }*/
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if (element == 23) {
                    //set.removeObserver(this);
                    // this will lead in thread "main" java.util.ConcurrentModificationException
                    // because notifyElementAdded is in the process of iterating over the observers list
                    // when it invokes the observer's added method
                    ExecutorService exec =
                            Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(() -> set.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });

        for(int i = 0;i < 100;i++) {
            set.add(i);
        }
    }
        // comment set.removeObserver(this) user ExecutorService this lead to
        // deadlock.The background thread calls set.removeObserver(this),which
        // attempts to lock observers,but it can't acquire the lock,because the main
        // thread already has the lock. All the while,the main thread is waiting for
        //the background thread to finish removing the observer , which explain the deadlock



}

