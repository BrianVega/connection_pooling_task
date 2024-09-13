package com.gd.sql.injection.task;

public class Counter {
    private int count;

    public synchronized void increment() {
        count += 1;
    }

    public synchronized int getCount() {
        return count;
    }
}
