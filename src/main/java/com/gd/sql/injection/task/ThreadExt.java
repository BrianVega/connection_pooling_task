package com.gd.sql.injection.task;

public class ThreadExt extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread: " + currentThread().threadId() + " - " + i);
        }
    }
}
