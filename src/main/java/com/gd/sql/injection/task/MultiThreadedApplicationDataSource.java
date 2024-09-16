package com.gd.sql.injection.task;

import com.gd.sql.injection.task.utils.DbUtilsDataSource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadedApplicationDataSource {
    static long run(int numberOfThreads) throws InterruptedException {
        DbUtilsDataSource dbUtilsDataSource = new DbUtilsDataSource();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> new SleepTaskDataSource(dbUtilsDataSource).run());
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);


        long endTime = System.currentTimeMillis();

        return endTime - startTime;

    }
}
