package com.gd.sql.injection.task;

import com.gd.sql.injection.task.database.DbUtils;

public class Main {
    public static void main(String[] args) {
        DbUtils dbUtils = new DbUtils();
        try {
            System.out.println(dbUtils.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }


//        ThreadExt thread1 = new ThreadExt();
//        ThreadExt thread2 = new ThreadExt();
//        thread1.start();
//        thread2.start();

        ThreadImpl t1 = new ThreadImpl();
        Thread thread1Impl = new Thread(t1);
        Thread thread2Impl = new Thread(t1);

        thread1Impl.start();
        thread2Impl.start();
    }
}